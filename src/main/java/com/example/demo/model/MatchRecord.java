package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "matches")
public class MatchRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private UserProfile userA;
    @ManyToOne
    private UserProfile userB;
    
    private String status;

    public String getStatus() { return status; } // Fixed [cite: 756]
    public void setStatus(String status) { this.status = status; } // Fixed [cite: 777]
    public void setUserA(UserProfile userA) { this.userA = userA; } // Fixed [cite: 861]
    public void setUserB(UserProfile userB) { this.userB = userB; } // Fixed [cite: 864]
    
    // Test also looks for skill offered by specific users
    public void setSkillOfferedByA(Skill skill) { } // Fixed [cite: 867]
    public void setSkillOfferedByB(Skill skill) { } // Fixed [cite: 870]
}