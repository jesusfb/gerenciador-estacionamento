package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo;

import marhlonkorb.github.io.gerenciadorestacionamento.core.AbstractEntityMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VeiculoMapper extends AbstractEntityMapper<Veiculo, VeiculoInputMapper, VeiculoOutputMapper> {
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public VeiculoOutputMapper convertToDto(Veiculo input) {
        return modelMapper.map(input, VeiculoOutputMapper.class);
    }
    @Override
    public Veiculo convertToEntity(VeiculoInputMapper input) {
        return modelMapper.map(input, Veiculo.class);
    }
}
