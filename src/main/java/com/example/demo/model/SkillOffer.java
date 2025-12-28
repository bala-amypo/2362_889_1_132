package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_offers")
public class SkillOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private UserProfile user;
    
    @ManyToOne
    private Skill skill;
    
    private String experienceLevel;
    private boolean active = true;

    public Long getId() { return id; } // Fixed [cite: 734]
    public void setId(Long id) { this.id = id; } // Fixed [cite: 1001]
    public UserProfile getUser() { return user; } // Fixed [cite: 841]
    public void setUser(UserProfile user) { this.user = user; } // Fixed [cite: 838]
    public Skill getSkill() { return skill; } // Fixed [cite: 908]
    public void setSkill(Skill skill) { this.skill = skill; } // Fixed [cite: 835]
    public String getExperienceLevel() { return experienceLevel; } // Fixed [cite: 727]
    public void setExperienceLevel(String level) { this.experienceLevel = level; } // Fixed [cite: 724]
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; } // Fixed [cite: 765]
}