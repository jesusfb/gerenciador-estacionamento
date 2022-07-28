package marhlonkorb.github.io.gerenciadorestacionamento.models.services.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.data.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {

}
