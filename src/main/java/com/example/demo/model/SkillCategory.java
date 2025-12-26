package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
        mappedBy = "skillCategory",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<SkillRequest> skillRequests;

    // Constructors
    public SkillCategory() {}

    public SkillCategory(String name) {
        this.name = name;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SkillRequest> getSkillRequests() {
        return skillRequests;
    }

    public void setSkillRequests(List<SkillRequest> skillRequests) {
        this.skillRequests = skillRequests;
    }
}
