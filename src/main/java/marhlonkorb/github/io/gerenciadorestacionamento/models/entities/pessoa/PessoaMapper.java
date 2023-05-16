package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.core.converter.DataConverter;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PessoaMapper extends AbstractEntityMapper<Pessoa, PessoaInputMapper, PessoaOutputMapper> {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public PessoaOutputMapper doWrap(Pessoa input) {
        final PessoaOutputMapper outputMapper = new PessoaOutputMapper();
        outputMapper.setNome(input.getNome());
        outputMapper.setCpf(input.getCpf());
        outputMapper.setApartamento(input.getApartamento());
        outputMapper.setDataNascimento(input.getDataNascimento());
        return outputMapper;
    }

    @Override
    public Pessoa doUnwrap(PessoaInputMapper input) {
        final Pessoa pessoaEncontrada = pessoaRepository.findById(input.getId()).orElse(new Pessoa());
        final Usuario usuarioEncontrado = usuarioRepository.findById(input.getIdUsuario()).get();
        pessoaEncontrada.setId(input.getId());
        pessoaEncontrada.setUsuario(usuarioEncontrado);
        pessoaEncontrada.setCpf(input.getCpf());
        pessoaEncontrada.setApartamento(input.getApartamento());
        pessoaEncontrada.setDataNascimento(DataConverter.converteStringParaData(input.getDataNascimento()));
        pessoaEncontrada.setTelefone(input.getTelefone());
        return null;
    }

}
