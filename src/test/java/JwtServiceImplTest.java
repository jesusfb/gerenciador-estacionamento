//import marhlonkorb.github.io.gerenciadorestacionamento.auth.IJwt;
//import marhlonkorb.github.io.gerenciadorestacionamento.auth.JwtService;
//import org.junit.jupiter.api.Test;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class JwtServiceImplTest {
//
//    private final String secret = "mySecretKey";
//
//    @Test
//    public void testGenerateAndValidateToken() {
//        IJwt jwtService = new JwtService();
//        UserDetails userDetails = new User("username", "password", new ArrayList<>());
//
//        String token = jwtService.generateToken(userDetails);
//        assertNotNull(token);
//
//        boolean isTokenValid = jwtService.isValidToken(token);
//        assertTrue(isTokenValid);
//
//        String username = jwtService.getUsernameFromToken(token);
//        assertEquals("username", username);
//    }
//}