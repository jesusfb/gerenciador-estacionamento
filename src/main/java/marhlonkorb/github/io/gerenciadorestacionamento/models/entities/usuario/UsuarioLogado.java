package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import com.nimbusds.jose.shaded.gson.Gson;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.UserRole;

public record UsuarioLogado(Long id, String nome, String email, UserRole role, Status status) {

    /**
     * Converte o objeto para o formato JSON
     * @return
     */
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }



}

