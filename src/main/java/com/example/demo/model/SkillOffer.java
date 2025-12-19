package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skill_offers")
public class SkillOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String experienceLevel;

    @Column(nullable = false)
    private Integer availableHoursPerWeek;

    @Column(nullable = false)
    private Boolean active;

    public SkillOffer() {
    }

    public SkillOffer(long id, String experienceLevel, Integer availableHoursPerWeek, Boolean active) {
        this.id = id;
        this.experienceLevel = experienceLevel;
        this.availableHoursPerWeek = availableHoursPerWeek;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public Integer getAvailableHoursPerWeek() {
        return availableHoursPerWeek;
    }

    public void setAvailableHoursPerWeek(Integer availableHoursPerWeek) {
        this.availableHoursPerWeek = availableHoursPerWeek;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
