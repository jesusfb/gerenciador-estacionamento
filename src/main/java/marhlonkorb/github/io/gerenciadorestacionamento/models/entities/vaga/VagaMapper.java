package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import marhlonkorb.github.io.gerenciadorestacionamento.core.IGenericEntityMapper;
import marhlonkorb.github.io.gerenciadorestacionamento.repositories.VagaRepository;
import marhlonkorb.github.io.gerenciadorestacionamento.repositories.VeiculoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VagaMapper implements IGenericEntityMapper<Vaga, VagaInputMapper, VagaOutputMapper> {

    @Autowired
    VagaRepository vagaRepository;

    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public VagaOutputMapper convertToDto(Vaga input) {
        return modelMapper.map(input, VagaOutputMapper.class);
    }

    @Override
    public Vaga convertToEntity(VagaInputMapper input) {
        return modelMapper.map(input, Vaga.class);
    }

}
