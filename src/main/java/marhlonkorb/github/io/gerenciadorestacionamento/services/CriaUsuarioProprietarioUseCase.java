package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioInputCadastro;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.builder.UsuarioBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CriaUsuarioProprietarioUseCase {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProprietarioService proprietarioService;

    @Transactional(rollbackFor = Exception.class)
    public void execute(UsuarioInputCadastro usuarioInputCadastro) {
        var usuarioConvertido = new UsuarioBuilder()
                .setEmail(usuarioInputCadastro.email())
                .setPassword(usuarioInputCadastro.password())
                .setRole(usuarioInputCadastro.role())
                .build();
        // Cria o usuário
        usuarioService.create(usuarioConvertido);
        // Cria o proprietário e vincula o usuário criado
        proprietarioService.adicionaUsuarioNovoProprietario(usuarioConvertido);
    }
}
