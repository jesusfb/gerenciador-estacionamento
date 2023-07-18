package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.vaga;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Ocupada;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;

/**
 * Output da entidade Vaga
 */
public class VagaOutputMapper {

    private Long id;

    private Long idVeiculo;

    private Status status;

    private Ocupada ocupada;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
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
