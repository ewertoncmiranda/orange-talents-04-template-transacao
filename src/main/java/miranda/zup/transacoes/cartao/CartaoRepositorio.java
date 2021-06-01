package miranda.zup.transacoes.cartao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepositorio extends CrudRepository<Cartao ,Long> {
    public Optional<Cartao> findByNumeroDoCartao(String numeroDoCartao);
}
