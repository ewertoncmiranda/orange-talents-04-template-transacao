package miranda.zup.transacoes.kafka;

import miranda.zup.transacoes.cartao.CartaoRepositorio;
import miranda.zup.transacoes.transacao.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class OuvinteDoKafka{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CartaoRepositorio cartaoRepositorio ;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(TransacaoResponse eventoDeTransacao) {
        eventoDeTransacao.toModel(entityManager , cartaoRepositorio);
        System.out.println(eventoDeTransacao.toString());
    }

}