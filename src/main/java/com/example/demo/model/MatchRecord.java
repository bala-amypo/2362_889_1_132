package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_records")
public class MatchRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AppUser userA;

    @ManyToOne
    private AppUser userB;

    @ManyToOne
    private Skill skillOfferedByA; // Required by test line 384

    @ManyToOne
    private Skill skillOfferedByB; // Required by test line 385

    private String status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AppUser getUserA() { return userA; }
    public void setUserA(AppUser userA) { this.userA = userA; }

    public AppUser getUserB() { return userB; }
    public void setUserB(AppUser userB) { this.userB = userB; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Fixed: Added Skill Barter methods for the test
    public void setSkillOfferedByA(Skill skill) { this.skillOfferedByA = skill; }
    public Skill getSkillOfferedByA() { return skillOfferedByA; }

    public void setSkillOfferedByB(Skill skill) { this.skillOfferedByB = skill; }
    public Skill getSkillOfferedByB() { return skillOfferedByB; }
}