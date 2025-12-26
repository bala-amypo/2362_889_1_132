package com.example.barter.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {
    
    private final String secret;
    private final long validityInMs;
    
    public JwtUtil(@Value("${jwt.secret}") String secret, @Value("${jwt.validity}") long validityInMs) {
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
    
    public Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
    
    public boolean validateToken(String token) {
        try {
            Claims claims = getAllClaims(token);
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getEmail(String token) {
        return getAllClaims(token).getSubject();
    }
    
    public String getRole(String token) {
        return (String) getAllClaims(token).get("role");
    }
}