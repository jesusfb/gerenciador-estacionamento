package marhlonkorb.github.io.gerenciadorestacionamento.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.entities.Estacionamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Integer> {
}
