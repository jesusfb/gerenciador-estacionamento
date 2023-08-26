package marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadeauditada;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadecomid.EntidadeComId;

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
    private String criadoPor;
    @Column
    private String alteradoPor;

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

}
