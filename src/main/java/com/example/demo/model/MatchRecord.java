package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "match_records")
public class MatchRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @ManyToOne @JoinColumn(name = "user_a_id")
    private UserProfile userA;
    @ManyToOne @JoinColumn(name = "user_b_id")
    private UserProfile userB;
    @ManyToOne private Skill skillOfferedByA;
    @ManyToOne private Skill skillOfferedByB;
    // Getters and Setters... [cite: 410-421]
}