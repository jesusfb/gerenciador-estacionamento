package marhlonkorb.github.io.gerenciadorestacionamento.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, String> {
}
