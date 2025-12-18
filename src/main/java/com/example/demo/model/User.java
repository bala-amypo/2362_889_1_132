package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private long id;

    private String fullname;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;
    private LocalDateTime createdAt;

    public User() {
    }

    public User(long id, String fullname, String email, String password, String role, LocalDateTime createdAt) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
 
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
 
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
