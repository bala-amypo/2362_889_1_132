package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private boolean active = true;
    // Getters and Setters... [cite: 436-443]
}