package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
public class Vaga {

    @Id
    @Max(value = 199)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(targetEntity = Veiculo.class)
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Vaga() {
    }

    public Vaga(Status status) {
        this.status = Status.ATIVO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
