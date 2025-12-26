package com.example.demo.util;

import com.example.demo.model.SkillRequest;
import java.util.List;

public class SkillMatchingEngine {

    public static void matchSkills(List<SkillRequest> requests) {

        for (SkillRequest request : requests) {

            String skillName = request.getSkillName();
            int requiredLevel = request.getRequiredLevel();

            // ✅ int is handled correctly
            System.out.println(
                "Matching skill: " + skillName +
                " | Required Level: " + requiredLevel
            );

            // Example matching logic
            if (requiredLevel >= 5) {
                System.out.println("→ Advanced level skill request");
            } else {
                System.out.println("→ Beginner/Intermediate skill request");
            }
        }
    }
}
