package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa;

import com.fasterxml.jackson.annotation.JsonFormat;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstract_entity.Entidade;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.time.LocalDate;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
public class Pessoa extends Entidade {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @CPF(message = "CPF inválido")
    @NotNull(message = "CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Número do apartamento é obrigatório")
    private String apto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_nascimento;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;

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

    public String getApto() {
        return apto;
    }

    public void setApto(String apto) {
        this.apto = apto;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
