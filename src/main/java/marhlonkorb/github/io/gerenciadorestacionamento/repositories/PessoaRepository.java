package marhlonkorb.github.io.gerenciadorestacionamento.repositories;

import marhlonkorb.github.io.gerenciadorestacionamento.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
