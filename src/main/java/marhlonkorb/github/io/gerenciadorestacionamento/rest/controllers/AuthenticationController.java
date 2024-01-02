package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import jakarta.validation.Valid;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.AuthenticationDTO;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.LoginResponseDTO;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.RegisterDTO;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.validador.IUsuarioValidador;
import marhlonkorb.github.io.gerenciadorestacionamento.security.TokenService;
import marhlonkorb.github.io.gerenciadorestacionamento.services.UsuarioService;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

/**
 * Controller que valida a autenticação do usuário
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;
    private final IUsuarioValidador iUsuarioValidador;

    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioService usuarioService, IUsuarioValidador iUsuarioValidador) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
        this.iUsuarioValidador = iUsuarioValidador;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO data) {
        iUsuarioValidador.validaIsUsuarioInexistente(data.email());
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        // Gera o token para o usuário
        var token = tokenService.generateToken(
                (Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        usuarioService.create(data);
        return ResponseEntity.ok().build();
    }
}
