package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper extends AbstractEntityMapper<Usuario, UsuarioInputMapper, UsuarioOutputMapper> {

    @Override
    public UsuarioOutputMapper convertToDto(Usuario input) {
        return null;
    }

    @Override
    public Usuario convertToEntity(UsuarioInputMapper usuarioInputMapper) {
        return null;
    }
}
