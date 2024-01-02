package marhlonkorb.github.io.gerenciadorestacionamento.validador;

/**
 * Interface para validação de uma entindade
 */
public interface IValidador<T> {

    /**
     * Executa a validação de uma entidade
     * @param Entity
     */
    void validar(T Entity);


}
