package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario;

import jakarta.persistence.*;
import marhlonkorb.github.io.gerenciadorestacionamento.core.abstractentities.entidadeauditada.EntidadeAuditada;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.Status;
import marhlonkorb.github.io.gerenciadorestacionamento.core.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Entidade Usuario
 */
@Entity
@Table(name = UsuarioDbConstantes.TABLE_NAME)
public class Usuario extends EntidadeAuditada implements UserDetails {
    @Column
    private String nome;

    @Column
    private String email;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    public Usuario() {
    }

    public Usuario(String email, String password, String nome, UserRole role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.nome = nome;
        this.status = Status.A;
    }

    public UsuarioLogado converteParaUsuarioLogado() {
        return new UsuarioLogado(
                this.getId(),
                this.getNome(),
                this.getEmail(),
                this.getRole(),
                this.getStatus());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        }
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
