package miranda.zup.transacoes.transacao;

import miranda.zup.transacoes.cartao.Cartao;
import miranda.zup.transacoes.cartao.CartaoRepositorio;
import miranda.zup.transacoes.cartao.CartaoResponse;
import miranda.zup.transacoes.estabelecimento.Estabelecimento;
import miranda.zup.transacoes.estabelecimento.EstabelecimentoResponse;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    public TransacaoResponse(){};

    private String id;
    private BigDecimal valor;
    private String efetivadaEm;
    private CartaoResponse cartao;
    private EstabelecimentoResponse estabelecimento;

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEfetivadaEm() {
        return efetivadaEm;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    @Override
    public String toString() {
        return "TransacaoResponse{" +
                "id='" + id + '\'' +
                ", valor=" + valor +
                ", efetivadaEm=" + efetivadaEm +
                ", cartao=" + cartao +
                ", estabelecimento=" + estabelecimento +
                '}';
    }

    @Transactional
    public Transacao toModel(EntityManager em , CartaoRepositorio repositorio) {
      Cartao novoCartao = cartao.toModel();

        if(repositorio.findByNumeroDoCartao(novoCartao.getNumeroDoCartao()).isEmpty()){
            em.persist(novoCartao);
        }else{
           novoCartao = repositorio.findByNumeroDoCartao(novoCartao.getNumeroDoCartao()).get();
        }

      Estabelecimento novoEstabelecimento = estabelecimento.toModel();

      em.persist(novoEstabelecimento);

      Transacao transacao = new Transacao(id,valor,efetivadaEm);
      transacao.setCartao(novoCartao);
      transacao.setEstabelecimento(novoEstabelecimento);
      em.persist(transacao);
      return transacao;
    }
}
