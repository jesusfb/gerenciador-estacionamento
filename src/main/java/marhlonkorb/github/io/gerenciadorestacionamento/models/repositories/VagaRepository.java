package marhlonkorb.github.io.gerenciadorestacionamento.models.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer> {
}
