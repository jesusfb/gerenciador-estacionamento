package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Role;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadeauditada.EntidadeAuditada;

import javax.persistence.*;
/**
 * Entidade Usuario
 */
@Entity
@Table(name = UsuarioDbConstantes.TABLE_NAME)
public class Usuario extends EntidadeAuditada {
    @Column(nullable = false)
    private String email;
    @Column
    private String senha;
    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;
    public Usuario() {
        this.status = Status.A;
    }

    public Usuario(String email) {
        this.email = email;
        this.role = Role.UM;
        this.status = Status.A;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
