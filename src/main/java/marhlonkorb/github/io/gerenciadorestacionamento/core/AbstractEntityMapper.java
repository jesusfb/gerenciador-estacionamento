package marhlonkorb.github.io.gerenciadorestacionamento.core;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadecomid.EntidadeComId;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractEntityMapper<T, Input, DtoType> {
    public abstract DtoType convertToDto(T input);
    public abstract T convertToEntity(Input input);

}
