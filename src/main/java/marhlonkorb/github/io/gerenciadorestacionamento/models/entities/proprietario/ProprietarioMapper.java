package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.IGenericEntityMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProprietarioMapper implements IGenericEntityMapper<Proprietario, ProprietarioInputMapper, ProprietarioOutputMapper> {
    private final ModelMapper modelMapper;

    public ProprietarioMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProprietarioOutputMapper convertToDto(Proprietario input) {
        return modelMapper.map(input, ProprietarioOutputMapper.class);
    }

    @Override
    public Proprietario convertToEntity(ProprietarioInputMapper input) {
        return modelMapper.map(input, Proprietario.class);
    }

}
