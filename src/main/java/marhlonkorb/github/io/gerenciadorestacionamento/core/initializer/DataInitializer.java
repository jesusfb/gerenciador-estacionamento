package marhlonkorb.github.io.gerenciadorestacionamento.core.initializer;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
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
    private UsuarioRepository userRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;

    private static final String URL = "jdbc:h2:mem:db";
    private static final String USUARIO = "sa";
    private static final String SENHA = "";

    @Override
    public void run(String... args) throws Exception {
        // Inserir dados iniciais para testes
        userRepository.save(new Usuario("John Doe"));
        userRepository.save(new Usuario("Jane Smith"));
        veiculoRepository.save(new Veiculo());

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO vaga (status, id_vaga) VALUES (?, ?)";

            try (PreparedStatement statement = ((Connection) connection).prepareStatement(query)) {
                for (int i = 0; i < 200; i++) {
                    // Crie um novo registro com os dados desejados
                    Vaga registro = new Vaga();
                    registro.setStatus(Status.ATIVO);
                    registro.setIdVaga(i + 1);
                    statement.setString(1, registro.getStatus().toString());
                    statement.setString(2, registro.getIdVaga().toString());
                    // Execute a inserção do registro
                    statement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ...
    }
}
