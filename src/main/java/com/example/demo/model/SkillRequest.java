package com.example.demo.model;

public class SkillRequest {

    private Long id;
    private String skillName;
    private String requiredLevel;
    private String urgencyLevel;

    // ----- ID -----
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ----- Skill Name -----
    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    // ----- Required Level -----
    public String getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(String requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    // ----- Urgency Level -----
    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }
}
