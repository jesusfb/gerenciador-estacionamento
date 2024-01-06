/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.*;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.validador.IUsuarioValidador;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.validador.email.IValidadorEmail;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Service da entidade Usuario
 */
@Service
public class UsuarioService extends AbstractEntityService<Usuario, Long, UsuarioInputMapper, UsuarioOutputMapper> {
    private final UsuarioRepository usuarioRepository;
    private final IUsuarioValidador iUsuarioValidador;
    private final IValidadorEmail iValidadorEmail;

    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, IUsuarioValidador iUsuarioValidador, IValidadorEmail iValidadorEmail, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.iUsuarioValidador = iUsuarioValidador;
        this.iValidadorEmail = iValidadorEmail;
        this.usuarioMapper= usuarioMapper;
    }

    @Override
    public Object convertToDto(Object input) {
        return usuarioMapper.convertToDto((Usuario) input);
    }

    @Override
    public Object convertToEntity(Object input) {
        return usuarioMapper.convertToEntity((UsuarioInputMapper) input);
    }


    public Usuario create(RegisterDTO data) {
        iUsuarioValidador.validaIsUsuarioExistente(data.email());
        iValidadorEmail.validar(data.email());
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        final var newUser = new Usuario(data.email(), encryptedPassword, data.nome(), data.role());
        return usuarioRepository.save(newUser);
    }
}
