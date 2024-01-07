package marhlonkorb.github.io.gerenciadorestacionamento.core.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserRole {
    // AE = Admin Empresa
    // UM = Usuario Comum
    ADMIN("Admin"), USER("Usuário comum");

    private String value;

    UserRole(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return name();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static UserRole fromValue(String value) {
        for (UserRole status : UserRole.values()) {
            if (status.value.equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor de enum inválido: " + value);
    }
}
