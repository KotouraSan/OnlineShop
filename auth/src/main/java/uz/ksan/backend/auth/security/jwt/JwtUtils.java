package uz.ksan.backend.auth.security.jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import uz.ksan.backend.auth.security.service.service.UserDetailsImpl;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;


@Component
public class JwtUtils {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationInMs:86400000}")
    private int jwtExpirationMs;

    private Key key;

    @PostConstruct // Метод будет вызван после создания бина
    public void init() {
        // Декодируем секретный ключ из Base64 и создаем объект Key
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    private Key getSigningKey(){
        if(key == null){
            key = new SecretKeySpec(jwtSecret.getBytes(), "HmacSHA256");
        }
        return key;
    }
    public String generateJwtToken(Authentication authentication) {


        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken).getBody().getSubject();
            return true;
        }
        catch (JwtException e) {

        }
        return false;
    }

}
