package marhlonkorb.github.io.gerenciadorestacionamento.core;

import org.springframework.stereotype.Component;

@Component
public interface IGenericEntityMapper<EntidadeComId, Input, DtoType> {
    public abstract DtoType convertToDto(EntidadeComId input);
    public abstract EntidadeComId convertToEntity(Input input);

}
