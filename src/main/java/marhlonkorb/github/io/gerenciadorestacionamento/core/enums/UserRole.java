package marhlonkorb.github.io.gerenciadorestacionamento.core.enums;

public enum UserRole {
    // AE = Admin Empresa
    // UM = Usuario Morador
    ADMIN("admin"), USER("user");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
