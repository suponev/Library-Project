package ru.library.security;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class TokenHandler {
    private final SecretKey secretKey;

    public TokenHandler() {
        String jwtKey = "jwt";
        byte[] decodedKey = BaseEncoding.base64().decode(jwtKey);
        secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    public Optional<String> extractUserName(@NonNull String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            return Optional
                    .ofNullable(body.get("username", String.class));

        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }

    public String generateAccessToken(String username) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);

        String tocken = Jwts.builder()
                //.setHeaderParam("username", username)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return tocken;
    }
}