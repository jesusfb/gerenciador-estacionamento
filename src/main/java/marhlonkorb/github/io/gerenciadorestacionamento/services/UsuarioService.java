/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.RegisterDTO;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.UsuarioOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.validador.email.IValidadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Usuario
 */
@Service
public class UsuarioService extends AbstractEntityService<Usuario, Long, UsuarioInputMapper, UsuarioOutputMapper> {

    @Override
    public Object convertToDto(Object input) {
        return null;
    }

    @Override
    public Object convertToEntity(Object o) {
        return null;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private IValidadorEmail iValidadorEmail;

    public void create(RegisterDTO data) {
        iValidadorEmail.validar(data.email());
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        final var newUser = new Usuario(data.email(), encryptedPassword, data.role());
        usuarioRepository.save(newUser);
    }
}
