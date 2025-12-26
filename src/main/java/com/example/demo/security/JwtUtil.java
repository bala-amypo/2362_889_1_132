package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final String secret = "mySecretKey123456789"; // use long key
    private final long validityInMs = 86400000; // 1 day

    // Generate JWT token
    public String generateToken(String email, String role, Long userId) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", role);
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    // Validate token
    public boolean validateToken(String token) {
        try {
            Claims claims = getAllClaims(token);
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    // Used in JwtFilter
    public String getEmail(String token) {
        return getAllClaims(token).getSubject();
    }

    // Used in JwtFilter
    public String getRole(String token) {
        return getAllClaims(token).get("role", String.class);
    }

    public Long getUserId(String token) {
        return getAllClaims(token).get("userId", Long.class);
    }

    private Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
