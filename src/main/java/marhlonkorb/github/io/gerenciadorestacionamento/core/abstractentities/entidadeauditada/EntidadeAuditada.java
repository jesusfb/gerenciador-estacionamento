package marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadeauditada;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadecomid.EntidadeComId;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.util.Date;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

/**
 * Classe abstrata que representa uma entidade auditada
 */
@MappedSuperclass
public abstract class EntidadeAuditada extends EntidadeComId {

    @Column
    protected String criadoPor;
    @Column
    private String alteradoPor;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataCriacao = new Date();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dataAlteracao;

    public String getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(String criadoPor) {
        this.criadoPor = criadoPor;
    }

    public String getAlteradoPor() {
        return alteradoPor;
    }

    public void setAlteradoPor(String alteradoPor) {
        this.alteradoPor = alteradoPor;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
