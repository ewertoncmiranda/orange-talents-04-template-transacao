package miranda.zup.transacoes.sistemaexterno;

import miranda.zup.transacoes.cartao.CartaoRequester;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url = "http://localhost:7777" ,name = "transacao")
@Component
public interface SistemaDeTransacoes {

    @PostMapping("/api/cartoes")
    public void iniciarTransacoes(@RequestBody CartaoRequester cartaoRequester) ;

    @DeleteMapping("/api/cartoes/{cartaoNumero}")
    public void pararTransacoes(@PathVariable String cartaoNumero);

}
