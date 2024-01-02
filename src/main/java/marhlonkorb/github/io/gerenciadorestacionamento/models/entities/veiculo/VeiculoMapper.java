package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.models.repositories.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper extends AbstractEntityMapper<Veiculo, VeiculoInputMapper, VeiculoOutputMapper> {

    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public VeiculoOutputMapper convertToDto(Veiculo output) {
        return modelMapper.map(output, VeiculoOutputMapper.class);
    }

    @Override
    public Veiculo convertToEntity(VeiculoInputMapper input) {
        final Veiculo veiculoEncontrado =input.getId() != null ? veiculoRepository.findById(input.getId()).get() : new Veiculo();
        veiculoEncontrado.setPlaca(input.getPlaca());
        veiculoEncontrado.setMarca(input.getMarca());
        veiculoEncontrado.setModelo(input.getModelo());
        veiculoEncontrado.setAno(input.getAno());
        return veiculoEncontrado;
    }
}
