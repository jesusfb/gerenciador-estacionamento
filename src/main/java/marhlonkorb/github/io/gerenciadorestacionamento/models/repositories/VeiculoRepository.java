package marhlonkorb.github.io.gerenciadorestacionamento.models.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

}
