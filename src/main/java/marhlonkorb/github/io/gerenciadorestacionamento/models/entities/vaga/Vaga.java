package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Ocupada;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadeauditada.EntidadeAuditada;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;

import javax.persistence.*;

/**
 * Entidade Vaga
 */
@Entity(name = VagaDbConstantes.TABLE_NAME)
public class Vaga extends EntidadeAuditada {

    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = VagaDbConstantes.VEICULO_ID)
    private Veiculo veiculo;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.A;
    @Column
    @Enumerated(EnumType.STRING)
    private Ocupada ocupada = Ocupada.N;

    public Vaga(Ocupada ocupada) {
        this.ocupada = Ocupada.N;
    }

    public Vaga() {

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

    public Ocupada getOcupada() {
        return ocupada;
    }

    public void setOcupada(Ocupada ocupada) {
        this.ocupada = ocupada;
    }
}
