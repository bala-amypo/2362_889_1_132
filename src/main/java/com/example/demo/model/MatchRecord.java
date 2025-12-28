package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_records")
public class MatchRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Change the type from UserProfile to AppUser
    @ManyToOne
    private AppUser userA;

    @ManyToOne
    private AppUser userB;

    @ManyToOne
    private Skill skillOfferedByA;

    @ManyToOne
    private Skill skillOfferedByB;

    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    // Use AppUser here to match the test requirements
    public AppUser getUserA() { return userA; }
    public void setUserA(AppUser userA) { this.userA = userA; }

    public AppUser getUserB() { return userB; }
    public void setUserB(AppUser userB) { this.userB = userB; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void setSkillOfferedByA(Skill skill) { this.skillOfferedByA = skill; }
    public Skill getSkillOfferedByA() { return skillOfferedByA; }

    public void setSkillOfferedByB(Skill skill) { this.skillOfferedByB = skill; }
    public Skill getSkillOfferedByB() { return skillOfferedByB; }
}