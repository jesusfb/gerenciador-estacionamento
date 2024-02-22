package marhlonkorb.github.io.gerenciadorestacionamento.core;

import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadecomid.EntidadeComId;
import org.springframework.stereotype.Component;

@Component
public interface AbstractEntityMapper<EntidadeComId, Input, DtoType> {
    public abstract DtoType convertToDto(EntidadeComId input);
    public abstract EntidadeComId convertToEntity(Input input);

}
