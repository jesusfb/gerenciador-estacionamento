/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.exceptions.UsuarioException;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.validador.IUsuarioValidador;
import marhlonkorb.github.io.gerenciadorestacionamento.repositories.UsuarioRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.validador.email.IValidadorEmail;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Service da entidade Usuario
 */
@Service
public class UsuarioService extends AbstractEntityService<Usuario, Long, UsuarioInputMapper, UsuarioOutputMapper> {
    private final UsuarioRepository usuarioRepository;
    private final IUsuarioValidador iUsuarioValidador;
    private final IValidadorEmail iValidadorEmail;


    public UsuarioService(UsuarioRepository usuarioRepository, IUsuarioValidador iUsuarioValidador, IValidadorEmail iValidadorEmail) {
        this.usuarioRepository = usuarioRepository;
        this.iUsuarioValidador = iUsuarioValidador;
        this.iValidadorEmail = iValidadorEmail;
    }

    /**
     * Cria um novo usuário
     *
     * @param usuario
     * @return Usuario
     */
    public Usuario create(Usuario usuario) {
        validar(usuario);
        String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setStatus(Status.A);
        return  usuarioRepository.save(usuario);
    }

    private void validar(Usuario usuario){
        iValidadorEmail.validar(usuario.getEmail());
        iUsuarioValidador.validaIsUsuarioExistente(usuario.getEmail());
    }

    public Usuario findById(Usuario usuario) {
        final Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuario.getId());
        if (usuarioEncontrado.isEmpty()) {
            throw new UsuarioException("Usuário não encontrado.");
        }
        return usuarioEncontrado.get();
    }

}
