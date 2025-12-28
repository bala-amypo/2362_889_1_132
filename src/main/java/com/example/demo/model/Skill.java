package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private boolean active = true;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; } // Fixed [cite: 715]
    public String getName() { return name; } // Fixed [cite: 721]
    public void setName(String name) { this.name = name; } // Fixed [cite: 718]
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; } // Fixed [cite: 829]
    public boolean isActive() { return active; } // Fixed [cite: 762]
    public void setActive(boolean active) { this.active = active; } // Fixed [cite: 759]
}