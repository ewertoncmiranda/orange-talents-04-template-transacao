package miranda.zup.transacoes.transacao;

import miranda.zup.transacoes.cartao.Cartao;
import miranda.zup.transacoes.estabelecimento.Estabelecimento;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    public Transacao(){};

    public Transacao(String id, BigDecimal valor, String efetivadaEm) {
        this.idTransacao = id;
        this.valor = valor;
        this.efetivadaEm = efetivadaEm;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id ;

    private String idTransacao ;

    @Positive
    private BigDecimal valor ;

    private String efetivadaEm ;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Cartao cartao ;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Estabelecimento estabelecimento;


    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
}
