package marhlonkorb.github.io.gerenciadorestacionamento.models.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository da entidade Pessoa
 */
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
