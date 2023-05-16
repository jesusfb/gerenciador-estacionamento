package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.abstractentities.entidadecomid.EntidadeComId;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
@Entity
@Table(name = UsuarioDbConstantes.TABLE_NAME)
public class Usuario extends EntidadeComId {

    @Column
    private String email;
    @Column
    private String senha;

    @Column
    @Enumerated
    private Role role;

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
}
