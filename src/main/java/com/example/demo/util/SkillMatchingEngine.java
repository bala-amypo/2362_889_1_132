package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import org.springframework.stereotype.Component; // Added Component annotation

import java.util.List;
import java.util.stream.Collectors;

@Component // Make this a Spring Bean so it can be injected into MatchServiceImpl
public class SkillMatchingEngine {

    // Existing method
    public static List<SkillOffer> matchSkills(
            List<SkillOffer> offers,
            SkillRequest request
    ) {
        return offers.stream()
                .filter(offer ->
                        offer.getSkillName().equalsIgnoreCase(request.getSkillName()))
                .collect(Collectors.toList());
    }

    // NEW METHOD: Added to fix the compilation error
    public double calculateMatchScore(SkillOffer offer, SkillRequest request) {
        if (offer == null || request == null) {
            return 0.0;
        }

        double score = 0.0;

        // Basic matching logic: Check if skill names match (case insensitive)
        if (offer.getSkillName().equalsIgnoreCase(request.getSkillName())) {
            score += 50.0;
        }

        // Check if levels match
        // Assuming simplistic logic: if offer is EXPERT, it covers everything.
        if (offer.getExperienceLevel().equalsIgnoreCase(request.getRequiredLevel())) {
            score += 50.0;
        } else if ("EXPERT".equalsIgnoreCase(offer.getExperienceLevel())) {
            score += 40.0; // Expert offers allow lower level requests
        }

        return score;
    }
}