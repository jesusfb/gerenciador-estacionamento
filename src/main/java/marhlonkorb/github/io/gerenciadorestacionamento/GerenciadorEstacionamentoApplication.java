package marhlonkorb.github.io.gerenciadorestacionamento;

import marhlonkorb.github.io.gerenciadorestacionamento.data.entities.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.services.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorEstacionamentoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorEstacionamentoApplication.class, args);
	}
	
}