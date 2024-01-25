package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Role;

public record RegisterDTO(String email, String password, String nome, Role role) {
}
