package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.core.utils.DataConverter;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaInputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.PessoaOutputMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
