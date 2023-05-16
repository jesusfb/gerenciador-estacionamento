//package marhlonkorb.github.io.gerenciadorestacionamento.auth;
//
//import io.jsonwebtoken.*;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class JwtService implements IJwt {
//
//    private static final String SECRET = "secret-key";
//
//    /* 20 minutos de expiração */
//    private static final long EXPIRATION_TIME = 1_200_000;
//
//    @Override
//    public String generateToken(UserDetails userDetails) {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime() + EXPIRATION_TIME);
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(now)
//                .setExpiration(expirationDate)
//                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .compact();
//    }
//
//    @Override
//    public String getUsernameFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    @Override
//    public boolean isValidToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
//            return true;
//        } catch (SignatureException ex) {
//            System.out.println("Invalid JWT signature");
//        } catch (MalformedJwtException ex) {
//            System.out.println("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            System.out.println("Expired JWT token");
//        } catch (UnsupportedJwtException ex) {
//            System.out.println("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            System.out.println("JWT claims string is empty");
//        }
//        return false;
//    }
//
//}
