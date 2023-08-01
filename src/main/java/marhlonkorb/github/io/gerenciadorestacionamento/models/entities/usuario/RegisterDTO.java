package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
