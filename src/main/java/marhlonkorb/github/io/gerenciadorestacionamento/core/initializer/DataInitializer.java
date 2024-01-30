package marhlonkorb.github.io.gerenciadorestacionamento.core.initializer;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.StatusVaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.ProprietarioRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VagaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private VagaRepository vagaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (vagaRepository.findAll().isEmpty()) {
            for (int i = 0; i < 200; i++) {
                // Crie um novo registro com os dados desejados
                Vaga registro = new Vaga(StatusVaga.L);
                // Executa a inserção dos registros
                registro.setStatus(Status.A);
                vagaRepository.save(registro);
            }
        }
    }
}