/*
 * gerenciador-estacionamento
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package marhlonkorb.github.io.gerenciadorestacionamento.services;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityService;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.*;
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

    private final UsuarioMapper usuarioMapper;

    private final ProprietarioService proprietarioService;

    public UsuarioService(UsuarioRepository usuarioRepository, IUsuarioValidador iUsuarioValidador, IValidadorEmail iValidadorEmail, UsuarioMapper usuarioMapper, ProprietarioService proprietarioService) {
        this.usuarioRepository = usuarioRepository;
        this.iUsuarioValidador = iUsuarioValidador;
        this.iValidadorEmail = iValidadorEmail;
        this.usuarioMapper = usuarioMapper;
        this.proprietarioService = proprietarioService;
    }

    @Override
    public UsuarioOutputMapper convertToDto(Usuario input) {
        return usuarioMapper.convertToDto(input);
    }

    @Override
    public Usuario convertToEntity(UsuarioInputMapper input) {
        return usuarioMapper.convertToEntity(input);
    }


    /**
     * Cria um novo usuário
     *
     * @param data
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public Usuario create(RegisterDTO data) {
        iUsuarioValidador.validaIsUsuarioExistente(data.email());
        iValidadorEmail.validar(data.email());
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        final var novoUsuario = new Usuario(data.email(), encryptedPassword, data.nome(), data.role());
        usuarioRepository.save(novoUsuario);
        // Cria o vínculo do usuário com um proprietário
        proprietarioService.create(novoUsuario);
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
