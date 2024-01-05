package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper extends AbstractEntityMapper<Usuario, UsuarioInputMapper, UsuarioOutputMapper> {

    private final ModelMapper modelMapper;

    public UsuarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UsuarioOutputMapper convertToDto(Usuario input) {
        return modelMapper.map(input, UsuarioOutputMapper.class);
    }

    @Override
    public Usuario convertToEntity(UsuarioInputMapper usuarioInputMapper) {
        return modelMapper.map(usuarioInputMapper, Usuario.class);
    }
}
