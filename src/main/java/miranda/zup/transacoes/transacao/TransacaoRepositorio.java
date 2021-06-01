package miranda.zup.transacoes.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepositorio extends CrudRepository<Transacao ,Long> {
    Page<Transacao> findByCartaoNumeroDoCartao(String numeroCartao, Pageable pageable);
}
