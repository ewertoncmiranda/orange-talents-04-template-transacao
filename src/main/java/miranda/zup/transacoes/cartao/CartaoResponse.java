package miranda.zup.transacoes.cartao;

public class CartaoResponse {

    public CartaoResponse(){};

    private String id ;

    private String email ;

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
