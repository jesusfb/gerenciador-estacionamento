package marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.validador;

import marhlonkorb.github.io.gerenciadorestacionamento.models.entities.usuario.exceptions.UsuarioException;
import marhlonkorb.github.io.gerenciadorestacionamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioValidadorImpl implements IUsuarioValidador {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validaIsUsuarioExistente(String email) {
        final var usuarioEncontrado = usuarioRepository.findByEmail(email);
        if(usuarioEncontrado != null){
            throw new UsuarioException("Usuário já cadastrado.");
        }
    }

    @Override
    public void validaIsUsuarioInexistente(String email) {
        final var usuarioEncontrado = usuarioRepository.findByEmail(email);
        if(usuarioEncontrado == null){
            throw new UsuarioException("Usuário não cadastrado.");
        }
    }

}
