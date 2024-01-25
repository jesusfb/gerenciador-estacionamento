package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import com.nimbusds.jose.shaded.gson.Gson;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Role;

public record UsuarioLogado(Long id, String nome, String email, Role role, Status status) {

    /**
     * Converte o objeto para o formato JSON
     * @return
     */
    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }



}

