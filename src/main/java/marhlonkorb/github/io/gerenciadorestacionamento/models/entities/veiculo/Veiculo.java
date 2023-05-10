package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstract_entity.Entidade;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.pessoa.Pessoa;

@Entity
public class Veiculo extends Entidade {

    @NotBlank(message = "A placa do veículo deve ser informada")
    private String placa;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Pessoa.class)
    @JoinColumn(name = "id_pessoa")
    private Pessoa pessoa;

    @NotBlank(message = "A marca do veículo é obrigatória informar")
    private String marca;

    @NotBlank(message = "O modelo do veículo é obrigatório informar")
    private String modelo;

    @JsonFormat(pattern = "yyyy")
    private Date ano;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }
}
