package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_requests")
public class SkillRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urgencyLevel;
    private boolean active = true;
    @ManyToOne @JoinColumn(name = "user_id")
    private UserProfile user;
    @ManyToOne @JoinColumn(name = "skill_id")
    private Skill skill;
    // Getters and Setters... [cite: 492-501]
}