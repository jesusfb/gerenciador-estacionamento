package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.validador;
/**
 * Interface que define contrato para as validações de usuário
 */
public interface IUsuarioValidador {

    public void validaIsUsuarioExistente(String email);
    public void validaIsUsuarioInexistente(String email);
}
