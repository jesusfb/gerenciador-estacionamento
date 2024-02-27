/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioInputCadastro;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.builder.UsuarioBuilder;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.exceptions.UsuarioException;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.validador.IUsuarioValidador;
import marhlonkorb.github.io.gerenciadorestacionamento.repositories.UsuarioRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.validador.email.IValidadorEmail;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service da entidade Usuario
 */
@Service
public class UsuarioService extends AbstractEntityService<Usuario, Long, UsuarioInputMapper, UsuarioOutputMapper> {
    private final UsuarioRepository usuarioRepository;
    private final IUsuarioValidador iUsuarioValidador;
    private final IValidadorEmail iValidadorEmail;

    private final ProprietarioService proprietarioService;

    public UsuarioService(UsuarioRepository usuarioRepository, IUsuarioValidador iUsuarioValidador, IValidadorEmail iValidadorEmail, ProprietarioService proprietarioService) {
        this.usuarioRepository = usuarioRepository;
        this.iUsuarioValidador = iUsuarioValidador;
        this.iValidadorEmail = iValidadorEmail;
        this.proprietarioService = proprietarioService;
    }

    /**
     * Cria um novo usuário
     *
     * @param usuarioInputCadastro
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Usuario create(UsuarioInputCadastro usuarioInputCadastro) {
        iUsuarioValidador.validaIsUsuarioExistente(usuarioInputCadastro.email());
        iValidadorEmail.validar(usuarioInputCadastro.email());
        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioInputCadastro.password());
        final var novoUsuario = new UsuarioBuilder()
                .setEmail(usuarioInputCadastro.email())
                .setPassword(encryptedPassword)
                .setRole(usuarioInputCadastro.role())
                .setStatus(Status.A).build();
        usuarioRepository.save(novoUsuario);
        // Cria o vínculo do usuário com um proprietário
        proprietarioService.adicionaUsuarioNovoProprietario(novoUsuario);
        return novoUsuario;
    }

    public Usuario findById(Usuario usuario) {
        final Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuario.getId());
        if (usuarioEncontrado.isEmpty()) {
            throw new UsuarioException("Usuário não encontrado.");
        }
        return usuarioEncontrado.get();
    }

}
