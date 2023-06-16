package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadecomid.EntidadeComId;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import org.hibernate.validator.constraints.br.CPF;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Entidade Pessoa
 */
@Entity
@Table(name = PessoaDbConstantes.TABLE_NAME)
public class Pessoa extends EntidadeComId {
    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = PessoaDbConstantes.ID_USUARIO, nullable = false)
    @JoinColumn(name = PessoaDbConstantes.USUARIO_ID)
    private Usuario usuario;

    @JoinColumn(name = "veiculo")
    @OneToMany
    private Set<Veiculo> veiculo;

    @NotNull(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @CPF(message = "CPF inválido")
    @NotNull(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Número do apartamento é obrigatório")
    private String apartamento;

    @Column(name = PessoaDbConstantes.DATA_NASCIMENTO)
    @JsonFormat(pattern = PessoaDbConstantes.DATA_NASCIMENTO_PATTERN)
    private LocalDate dataNascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

    public Pessoa() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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
