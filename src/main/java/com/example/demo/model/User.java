package com.example.barter.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String fullName;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    private String location;

    @Column(nullable=false)
    private String role = "USER";

    private Double rating = 0.0;

    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<SkillOffer> skillOffers;

    @OneToMany(mappedBy = "user")
    private List<SkillRequest> skillRequests;

    @PrePersist
    void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public User() {}

    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<SkillOffer> getSkillOffers() {
        return skillOffers;
    }

    public void setSkillOffers(List<SkillOffer> skillOffers) {
        this.skillOffers = skillOffers;
    }

    public List<SkillRequest> getSkillRequests() {
        return skillRequests;
    }

    public void setSkillRequests(List<SkillRequest> skillRequests) {
        this.skillRequests = skillRequests;
    }

}
