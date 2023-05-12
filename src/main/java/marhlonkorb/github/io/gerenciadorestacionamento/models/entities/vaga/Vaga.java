package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.veiculo.Veiculo;
import javax.persistence.*;
import javax.validation.constraints.Max;


@Entity(name = VagaDbConstantes.TABLE_NAME)
public class Vaga {

    @Id
    @Max(value = 199)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = VagaDbConstantes.VEICULO_ID)
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
