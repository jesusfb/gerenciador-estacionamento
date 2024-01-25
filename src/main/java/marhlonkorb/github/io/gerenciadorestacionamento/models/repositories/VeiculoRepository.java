package marhlonkorb.github.io.gerenciadorestacionamento.models.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Repository da entidade Veiculo
 */
@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Set<Veiculo> findAllByProprietarioId(Long idProprietario);
}
