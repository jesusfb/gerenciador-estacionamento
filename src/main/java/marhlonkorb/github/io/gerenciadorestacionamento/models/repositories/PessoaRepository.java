package marhlonkorb.github.io.gerenciadorestacionamento.models.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario.Proprietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository da entidade Proprietario
 */
@Repository
public interface PessoaRepository extends JpaRepository<Proprietario, Long> {
}
