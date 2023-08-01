package marhlonkorb.github.io.gerenciadorestacionamento.core.initializer;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Ocupada;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga.Vaga;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
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

    private static final String URL = "jdbc:h2:mem:db";
    private static final String USUARIO = "sa";
    private static final String SENHA = "";
//    @Autowired
//    private UsuarioRepository userRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void run(String... args) throws Exception {
        // Inserir dados iniciais para testes
//        userRepository.save(new Usuario("John Doe"));
//        var usuario = userRepository.save(new Usuario("Jane Smith"));
        var veiculo = new Veiculo();
        var pessoa = new Pessoa();
        pessoa.setNome("Julius");
        pessoa.setCpf("669.317.360-86");
//        pessoa.setUsuario(usuario);
        pessoaRepository.save(pessoa);
        veiculo.setPessoa(pessoa);
        veiculoRepository.save(veiculo);

        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String query = "INSERT INTO vaga (status, ocupada) VALUES (?, ?)";

            try (PreparedStatement statement = ((Connection) connection).prepareStatement(query)) {
                for (int i = 0; i < 200; i++) {
                    // Crie um novo registro com os dados desejados
                    Vaga registro = new Vaga();
                    registro.setOcupada(Ocupada.N);
                    statement.setString(1, registro.getStatus().toString());
                    statement.setString(2, registro.getOcupada().toString());
                    // Executa a inserção dos registros
                    statement.executeUpdate();
                }
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
