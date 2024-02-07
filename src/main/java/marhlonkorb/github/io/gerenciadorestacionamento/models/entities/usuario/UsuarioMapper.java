package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioMapper extends AbstractEntityMapper<Usuario, UsuarioInputMapper, UsuarioOutputMapper> {

    private final ModelMapper modelMapper;

    private final UsuarioRepository usuarioRepository;

    public UsuarioMapper(ModelMapper modelMapper, UsuarioRepository usuarioRepository) {
        this.modelMapper = modelMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioOutputMapper convertToDto(Usuario input) {
        return modelMapper.map(input, UsuarioOutputMapper.class);
    }

    @Override
    public Usuario convertToEntity(UsuarioInputMapper usuarioInputMapper) {
        setPasswordAntesAtualizarUsuario(usuarioInputMapper);
        return modelMapper.map(usuarioInputMapper, Usuario.class);
    }

    /**
     * Busca a senha do usuário e adiciona ao objeto usuario que será persistido
     *
     * @param usuarioInputMapper
     */
    private void setPasswordAntesAtualizarUsuario(UsuarioInputMapper usuarioInputMapper) {
        // Id do usuário não será nulo quando for atualização de usuário
        if (usuarioInputMapper.getId() != null) {
            Optional<Usuario> usuario = usuarioRepository.findById(usuarioInputMapper.getId());
            usuarioInputMapper.setPassword(usuario.get().getPassword());
        }
    }
}
