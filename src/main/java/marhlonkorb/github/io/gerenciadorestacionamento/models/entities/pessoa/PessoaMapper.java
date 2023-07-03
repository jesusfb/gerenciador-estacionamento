package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.core.utils.DataConverter;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.PessoaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Component
public class PessoaMapper extends AbstractEntityMapper<Pessoa, PessoaInputMapper, PessoaOutputMapper> {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PessoaOutputMapper convertToDto(Pessoa input) {
        return modelMapper.map(input, PessoaOutputMapper.class);
    }

    @Override
    public Pessoa convertToEntity(PessoaInputMapper input) {
        Pessoa pessoaEncontrada = input.getId() != null ? pessoaRepository.findById(input.getId()).get() : new Pessoa();
        final Usuario usuarioEncontrado = usuarioRepository.findById(input.getIdUsuario()).get();
        pessoaEncontrada.setUsuario(usuarioEncontrado);
        pessoaEncontrada.setNome(input.getNome());
        pessoaEncontrada.setCpf(input.getCpf());
        pessoaEncontrada.setApartamento(input.getApartamento());
        pessoaEncontrada.setDataNascimento(DataConverter.converteStringParaData(input.getDataNascimento()));
        pessoaEncontrada.setTelefone(input.getTelefone());
        return pessoaEncontrada;
    }

}
