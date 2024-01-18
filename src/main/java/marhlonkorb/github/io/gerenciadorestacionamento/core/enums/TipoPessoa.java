package marhlonkorb.github.io.gerenciadorestacionamento.core.enums;

public enum TipoPessoa {
    PF("Física"), PJ("Juridica");

    private String descricao;

    TipoPessoa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
