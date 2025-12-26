package com.example.barter.controller;

import com.example.barter.model.SkillOffer;
import com.example.barter.service.SkillOfferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offers")
@Tag(name = "Offer", description = "Skill offer management endpoints")
public class SkillOfferController {
    
    private final SkillOfferService skillOfferService;
    
    public SkillOfferController(SkillOfferService skillOfferService) {
        this.skillOfferService = skillOfferService;
    }
    
    @PostMapping("/")
    public ResponseEntity<SkillOffer> createOffer(@RequestBody SkillOffer offer) {
        SkillOffer savedOffer = skillOfferService.createOffer(offer);
        return ResponseEntity.ok(savedOffer);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SkillOffer>> getAllOffers() {
        // Implementation would need SkillOfferService.getAllOffers() method
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillOffer> getOffer(@PathVariable Long id) {
        SkillOffer offer = skillOfferService.getOffer(id);
        return ResponseEntity.ok(offer);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillOffer>> getOffersByUser(@PathVariable Long userId) {
        List<SkillOffer> offers = skillOfferService.getOffersByUser(userId);
        return ResponseEntity.ok(offers);
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SkillOffer>> getOffersByCategory(@PathVariable Long categoryId) {
        List<SkillOffer> offers = skillOfferService.getOffersByCategory(categoryId);
        return ResponseEntity.ok(offers);
    }
    
    @GetMapping("/available")
    public ResponseEntity<List<SkillOffer>> getAvailableOffers() {
        List<SkillOffer> offers = skillOfferService.getAvailableOffers();
        return ResponseEntity.ok(offers);
    }
}