package marhlonkorb.github.io.gerenciadorestacionamento.core;

public abstract class AbstractEntityMapper<Entity, DTOInput, DTOOutput>  {
    public abstract DTOOutput doWrap(Entity input);

    public abstract Entity doUnwrap(DTOInput input);
}
