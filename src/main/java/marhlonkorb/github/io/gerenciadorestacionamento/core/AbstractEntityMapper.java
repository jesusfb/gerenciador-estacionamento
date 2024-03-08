package marhlonkorb.github.io.gerenciadorestacionamento.core;

import org.springframework.stereotype.Component;

@Component
public abstract class AbstractEntityMapper<EntidadeComId, Input, DtoType> {

    protected abstract DtoType convertToDto(EntidadeComId input);
    protected abstract EntidadeComId convertToEntity(Input input);

}
