package marhlonkorb.github.io.gerenciadorestacionamento.auth;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwt {
    String generateToken(UserDetails userDetails);

    boolean validateToken(String token);

    String getUsernameFromToken(String token);
}
