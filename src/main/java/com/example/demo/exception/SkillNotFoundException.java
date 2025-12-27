package com.example.demo.exception;

public class SkillNotFoundException extends RuntimeException {
    public SkillNotFoundException() {
        super("Skill not found");
    }
}