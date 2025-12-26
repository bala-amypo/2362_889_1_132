package com.example.demo.model;

public class MatchRecord {

    private SkillRequest skillRequest;
    private Skill skill;

    public MatchRecord(SkillRequest skillRequest, Skill skill) {
        this.skillRequest = skillRequest;
        this.skill = skill;
    }

    public SkillRequest getSkillRequest() {
        return skillRequest;
    }

    public Skill getSkill() {
        return skill;
    }
}
