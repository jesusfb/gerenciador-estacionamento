package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.StatusVaga;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadeauditada.EntidadeAuditada;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;

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
    private Status status;
    @Column
    @Enumerated(EnumType.STRING)
    private StatusVaga statusVaga;

    public Vaga() {
    }

    public Vaga(StatusVaga statusVaga) {
        this.statusVaga = statusVaga;
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

    public StatusVaga getOcupada() {
        return statusVaga;
    }

    public void setOcupada(StatusVaga statusVaga) {
        this.statusVaga = statusVaga;
    }
}
