package com.example.barter.util;

import com.example.barter.model.SkillOffer;
import com.example.barter.model.SkillRequest;
import org.springframework.stereotype.Component;

@Component
public class SkillMatchingEngine {
    
    public double calculateMatchScore(SkillOffer offer, SkillRequest request) {
        double score = 0.0;
        
        // Skill name similarity
        if (offer.getSkillName().equalsIgnoreCase(request.getSkillName())) {
            score += 40.0;
        }
        
        // Category match
        if (offer.getSkillCategory().getId().equals(request.getSkillCategory().getId())) {
            score += 30.0;
        }
        
        // Experience level compatibility
        score += calculateExperienceScore(offer.getExperienceLevel(), request.getRequiredLevel());
        
        // User rating factor
        score += offer.getUser().getRating() * 5.0;
        
        return Math.min(score, 100.0);
    }
    
    private double calculateExperienceScore(String offerLevel, String requiredLevel) {
        if (offerLevel.equals(requiredLevel)) {
            return 20.0;
        }
        
        int offerLevelNum = getLevelNumber(offerLevel);
        int requiredLevelNum = getLevelNumber(requiredLevel);
        
        if (offerLevelNum >= requiredLevelNum) {
            return 15.0;
        }
        
        return 5.0;
    }
    
    private int getLevelNumber(String level) {
        switch (level) {
            case "BEGINNER": return 1;
            case "INTERMEDIATE": return 2;
            case "EXPERT": return 3;
            default: return 1;
        }
    }
}