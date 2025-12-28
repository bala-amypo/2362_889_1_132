package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_records")
public class MatchRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_a_id")
    private UserProfile userA; // Ensure this is UserProfile

    @ManyToOne
    @JoinColumn(name = "user_b_id")
    private UserProfile userB; // Ensure this is UserProfile

    @ManyToOne
    private Skill skillOfferedByA;

    @ManyToOne
    private Skill skillOfferedByB;

    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public UserProfile getUserA() { return userA; }
    public void setUserA(UserProfile userA) { this.userA = userA; }

    public UserProfile getUserB() { return userB; }
    public void setUserB(UserProfile userB) { this.userB = userB; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void setSkillOfferedByA(Skill s) { this.skillOfferedByA = s; }
    public Skill getSkillOfferedByA() { return skillOfferedByA; }

    public void setSkillOfferedByB(Skill s) { this.skillOfferedByB = s; }
    public Skill getSkillOfferedByB() { return skillOfferedByB; }
}