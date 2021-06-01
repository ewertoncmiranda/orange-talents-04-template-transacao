package miranda.zup.transacoes.cartao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartao {
    @Deprecated
    public Cartao(){};

    public Cartao(String numeroDoCartao, String email) {
        this.numeroDoCartao = numeroDoCartao;
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String numeroDoCartao ;

    private String email ;

    public Long getId() {
        return id;
    }

    public String getNumeroDoCartao() {
        return numeroDoCartao;
    }

    public String getEmail() {
        return email;
    }
}
