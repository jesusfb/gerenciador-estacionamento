package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadeauditada.EntidadeAuditada;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;

import javax.persistence.*;
import javax.validation.constraints.Max;
/**
 * Entidade Vaga
 */
@Entity(name = VagaDbConstantes.TABLE_NAME)
public class Vaga extends EntidadeAuditada {

    @Column(name = VagaDbConstantes.NUMERO_VAGA)
    @Max(value = 200)
    private Integer numeroVaga;

    @JsonManagedReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = VagaDbConstantes.VEICULO_ID)
    private Veiculo veiculo;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.A;

    public Integer getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(Integer numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
