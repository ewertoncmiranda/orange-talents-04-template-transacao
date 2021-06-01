package miranda.zup.transacoes.transacao;

import miranda.zup.transacoes.cartao.CartaoRepositorio;
import miranda.zup.transacoes.cartao.CartaoRequester;
import miranda.zup.transacoes.sistemaexterno.SistemaDeTransacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private SistemaDeTransacoes transacoes;

    @Autowired
    private CartaoRepositorio cartaoRepositorio;

    @Autowired
    private TransacaoRepositorio transacaoRepositorio ;

    @PostMapping
    public ResponseEntity iniciarTransacoes(@RequestBody CartaoRequester cartaoRequester){
      try {
          if(cartaoRepositorio.findByNumeroDoCartao(cartaoRequester.getId()).isPresent()){
              return ResponseEntity.badRequest().body("Erro!Cartao ja adicionado a transação.");
          }
          transacoes.iniciarTransacoes(cartaoRequester);
          return ResponseEntity.ok().build();
      }catch (Exception e){
          return ResponseEntity.badRequest().build();
      }
    }

    @DeleteMapping("/{cartaoNumero}")
    public ResponseEntity pararTransacoes(@PathVariable String cartaoNumero){
     try {
        if(cartaoRepositorio.findByNumeroDoCartao(cartaoNumero).isPresent()) {
            transacoes.pararTransacoes(cartaoNumero);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
     }catch (Exception e){
        return ResponseEntity.badRequest().build();
     }
    }
    @GetMapping("/{numeroCartao}")
    public ResponseEntity<?> buscarUltimos10Registros(@PathVariable("numeroCartao") String numeroCartao){
        Pageable pageable = PageRequest.of(0, 10, Sort.by("efetivadaEm").descending());
        Page<Transacao> pageDeTransacao = transacaoRepositorio.findByCartaoNumeroDoCartao(numeroCartao,pageable);
        List<TransacaoResponse> listaDeTransacaoResponse = pageDeTransacao.stream().map(transacao -> new TransacaoResponse(transacao)).collect(Collectors.toList());
        if(listaDeTransacaoResponse.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return  ResponseEntity.ok().body(listaDeTransacaoResponse);
    }
}
