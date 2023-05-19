package marhlonkorb.github.io.gerenciadorestacionamento.core;

public abstract class AbstractEntityMapper<Entity, Input, Output>  {
    public abstract Output doWrap(Entity input);
    public abstract Entity doUnwrap(Input input);
}
