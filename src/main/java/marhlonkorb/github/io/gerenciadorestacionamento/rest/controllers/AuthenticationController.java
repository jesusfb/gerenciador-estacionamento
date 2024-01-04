package marhlonkorb.github.io.gerenciadorestacionamento.rest.controllers;

import jakarta.validation.Valid;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.AuthenticationDTO;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.LoginResponseDTO;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.RegisterDTO;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.Usuario;
import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.validador.IUsuarioValidador;
import marhlonkorb.github.io.gerenciadorestacionamento.security.TokenService;
import marhlonkorb.github.io.gerenciadorestacionamento.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador responsável pela autenticação do usuário.
 */
@RestController
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UsuarioService usuarioService;
    private final IUsuarioValidador iUsuarioValidador;

    /**
     * Construtor da classe, injetando as dependências necessárias.
     *
     * @param authenticationManager Gerenciador de autenticação do Spring Security.
     * @param tokenService          Serviço para geração e validação de tokens JWT.
     * @param usuarioService        Serviço para manipulação de entidades de usuário.
     * @param iUsuarioValidador     Validador de usuário para garantir consistência nos dados.
     */
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService, UsuarioService usuarioService, IUsuarioValidador iUsuarioValidador) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.usuarioService = usuarioService;
        this.iUsuarioValidador = iUsuarioValidador;
    }

    /**
     * Endpoint para autenticar um usuário e gerar um token JWT.
     *
     * @param data Dados de autenticação fornecidos pelo usuário (email e senha).
     * @return Resposta contendo o token JWT se a autenticação for bem-sucedida.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO data) {
        // Valida se o usuário existe antes da autenticação
        iUsuarioValidador.validaIsUsuarioInexistente(data.email());
        // Cria um token de autenticação para o usuário
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);
        // Gera o token JWT para o usuário autenticado
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    /**
     * Endpoint para registrar um novo usuário e gerar um token JWT para o mesmo.
     *
     * @param data Dados do novo usuário a ser registrado.
     * @return Resposta contendo o token JWT gerado para o novo usuário.
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO data) {
        // Cria um novo usuário com base nos dados fornecidos
        var usuarioCriado = usuarioService.create(data);
        // Gera um token JWT para o novo usuário registrado
        var token = tokenService.generateToken(usuarioCriado);
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
