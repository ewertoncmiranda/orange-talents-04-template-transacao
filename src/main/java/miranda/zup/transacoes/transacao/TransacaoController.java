package miranda.zup.transacoes.transacao;

import miranda.zup.transacoes.cartao.CartaoRepositorio;
import miranda.zup.transacoes.cartao.CartaoRequester;
import miranda.zup.transacoes.sistemaexterno.SistemaDeTransacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private SistemaDeTransacoes transacoes;

    @Autowired
    private CartaoRepositorio cartaoRepositorio;

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
}
