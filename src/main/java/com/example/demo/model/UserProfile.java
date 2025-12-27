package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private boolean active = true;

    // ✅ FIX 1: Rename this constructor to UserProfile
    public UserProfile() {
    }

    // ✅ FIX 2: Rename this constructor to UserProfile
    public UserProfile(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Standard Getters and Setters ...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}