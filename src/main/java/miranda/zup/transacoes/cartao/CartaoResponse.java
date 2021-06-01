package miranda.zup.transacoes.cartao;

public class CartaoResponse {

    public CartaoResponse(){};

    private String id ;

    private String email ;

    public CartaoResponse(Cartao cartao) {
        this.id = cartao.getNumeroDoCartao();
        this.email = cartao.getEmail();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Cartao toModel(){
        return new Cartao(id,email);
    }

    @Override
    public String toString() {
        return "CartaoResponse{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
