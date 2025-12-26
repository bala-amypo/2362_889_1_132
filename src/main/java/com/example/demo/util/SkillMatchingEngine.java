// File: src/main/java/com/example/demo/util/SkillMatchingEngine.java

package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import org.springframework.stereotype.Component;

@Component
public class SkillMatchingEngine {

    public Double calculateMatchScore(SkillOffer offer, SkillRequest request) {
        // Basic matching logic based on your project requirements
        if (offer == null || request == null) return 0.0;
        
        double score = 0.0;
        // Example: Check if category matches
        if (offer.getSkillCategory().getId().equals(request.getSkillCategory().getId())) {
            score += 50.0;
        }
        
        // Add more logic based on tags, description, or availability
        return score;
    }
}