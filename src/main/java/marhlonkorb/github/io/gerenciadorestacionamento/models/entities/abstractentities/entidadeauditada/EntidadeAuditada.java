package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadeauditada;

import com.fasterxml.jackson.annotation.JsonFormat;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadecomid.EntidadeComId;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class EntidadeAuditada extends EntidadeComId {

    @Column
    private String criadoPor;
    @Column
    private String alteradoPor;
    @Column
    @JsonFormat(pattern = EntidadeAuditadaDbConstantes.DATE_PATTERN)
    private LocalDate dataCriacao;
    @Column
    @JsonFormat(pattern = EntidadeAuditadaDbConstantes.DATE_PATTERN)
    private LocalDate dataAlteracao;

    public EntidadeAuditada() {
        saveLocalDate();
    }

    private void saveLocalDate(){
        if(this.dataCriacao == null) {
            this.dataCriacao = LocalDate.now();
        } else {
            this.dataAlteracao = LocalDate.now();
        }
    }
}
