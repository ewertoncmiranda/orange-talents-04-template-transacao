package miranda.zup.transacoes.cartao;

import miranda.zup.transacoes.transacao.Transacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepositorio extends CrudRepository<Cartao ,Long> {
    public Optional<Cartao> findByNumeroDoCartao(String numeroDoCartao);


}
