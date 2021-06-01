package miranda.zup.transacoes.cartao;

import javax.validation.constraints.NotBlank;

public class CartaoRequester {

    public CartaoRequester(){};

    @NotBlank private String id ;
    @NotBlank private String email;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel(){
       return new Cartao(id ,email) ;
    }
}
