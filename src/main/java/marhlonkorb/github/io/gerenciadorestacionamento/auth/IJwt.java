package marhlonkorb.github.io.gerenciadorestacionamento.auth;


public interface IJwt {
//    String generateToken(UserDetails userDetails);

    boolean isValidToken(String token);

    String getUsernameFromToken(String token);
}
