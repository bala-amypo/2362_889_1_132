package com.example.demo.util;

import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;

import java.util.List;
import java.util.stream.Collectors;

public class SkillMatchingEngine {

    public static List<SkillOffer> matchSkills(
            List<SkillOffer> offers,
            SkillRequest request
    ) {
        return offers.stream()
                .filter(offer ->
                        offer.getSkillName().equalsIgnoreCase(request.getSkillName()))
                .collect(Collectors.toList());
    }
}
