package com.example.barter.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    private String secret = "mySecretKey";
    private long validityInMs = 86400000; // 24 hours

    public JwtUtil() {}

    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Map<String, Object> getAllClaims(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    public boolean validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmail(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String getRole(String token) {
        return (String) getAllClaims(token).get("role");
    }
}
