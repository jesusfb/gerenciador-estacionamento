package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.core.utils.DataConverter;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProprietarioMapper extends AbstractEntityMapper<Proprietario, ProprietarioInputMapper, ProprietarioOutputMapper> {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProprietarioOutputMapper convertToDto(Proprietario input) {
        return modelMapper.map(input, ProprietarioOutputMapper.class);
    }

    @Override
    public Proprietario convertToEntity(ProprietarioInputMapper input) {
        Proprietario proprietarioEncontrada = input.getId() != null ? pessoaRepository.findById(input.getId()).get() : new Proprietario();
        final Usuario usuarioEncontrado = usuarioRepository.findById(input.getIdUsuario()).get();
        proprietarioEncontrada.setUsuario(usuarioEncontrado);
        proprietarioEncontrada.setNome(input.getNome());
        proprietarioEncontrada.setCpfCnpj(input.getCpf());
        proprietarioEncontrada.setApartamento(input.getApartamento());
        proprietarioEncontrada.setDataNascimento(DataConverter.converteStringParaData(input.getDataNascimento()));
        proprietarioEncontrada.setTelefone(input.getTelefone());
        return proprietarioEncontrada;
    }

}
