package com.example.demo.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_profiles")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String email;
    private String role; // Added to fix test errors
    private boolean active = true;
    
    private LocalDateTime createdAt = LocalDateTime.now(); // Added to fix test errors
    private LocalDateTime updatedAt = LocalDateTime.now(); // Added to fix test errors

    public UserProfile() {
    }

    public UserProfile(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public String getRole() { return role; } // Added
    public void setRole(String role) { this.role = role; } // Added
    
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; } // Added
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; } // Added

    public LocalDateTime getUpdatedAt() { return updatedAt; } // Added
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; } // Added
}