package marhlonkorb.github.io.gerenciadorestacionamento.core.enums;

public enum StatusVaga {
    L("Livre"), O("Ocupada");

    private final String value;

    StatusVaga(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
