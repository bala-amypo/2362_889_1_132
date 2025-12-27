package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    public AppUser() { this.createdAt = LocalDateTime.now(); }
    public AppUser(String fullName, String email, String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = LocalDateTime.now();
    }
    // Getters and Setters omitted for brevity... [cite: 374-387]
}