package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.proprietario;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadecomid.EntidadeComId;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import java.time.LocalDate;
import java.util.Set;

/**
 * Entidade Proprietario
 */
@Entity
@Table(name = ProprietarioDbConstantes.TABLE_NAME)
public class Proprietario extends EntidadeComId {
    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = ProprietarioDbConstantes.ID_USUARIO, nullable = false)
    @JoinColumn(name = ProprietarioDbConstantes.USUARIO_ID)
    private Usuario usuario;

    @JoinColumn(name = "veiculo")
    @OneToMany
    private Set<Veiculo> veiculo;

    @NotNull(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    private String cpfCnpj;

    @NotBlank(message = "Número do apartamento é obrigatório")
    private String apartamento;

    @Column(name = ProprietarioDbConstantes.DATA_NASCIMENTO)
    @JsonFormat(pattern = ProprietarioDbConstantes.DATA_NASCIMENTO_PATTERN)
    private LocalDate dataNascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    public Proprietario() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
