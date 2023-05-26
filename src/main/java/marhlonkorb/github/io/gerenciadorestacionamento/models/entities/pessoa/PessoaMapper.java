package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.core.utils.DataConverter;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PessoaMapper extends AbstractEntityMapper<Pessoa, PessoaInputMapper, PessoaOutputMapper> {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public PessoaOutputMapper convertToDto(Pessoa input) {
        final PessoaOutputMapper outputMapper = new PessoaOutputMapper();
        return modelMapper.map(outputMapper, PessoaOutputMapper.class) ;
    }

    @Override
    public Pessoa convertToEntity(PessoaInputMapper input) {
        final Pessoa pessoaEncontrada = pessoaRepository.findById(input.getId()).orElse(new Pessoa());
        final Usuario usuarioEncontrado = usuarioRepository.findById(input.getIdUsuario()).get();
        pessoaEncontrada.setId(input.getId());
        pessoaEncontrada.setUsuario(usuarioEncontrado);
        pessoaEncontrada.setCpf(input.getCpf());
        pessoaEncontrada.setApartamento(input.getApartamento());
        pessoaEncontrada.setDataNascimento(DataConverter.converteStringParaData(input.getDataNascimento()));
        pessoaEncontrada.setTelefone(input.getTelefone());
        return pessoaEncontrada;
    }

}
