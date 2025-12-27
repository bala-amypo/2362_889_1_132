package com.example.demo.controller;

import com.example.demo.model.SkillMatch;
import com.example.demo.service.MatchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Match", description = "Skill match management endpoints")
public class MatchController {
    
    private final MatchService matchService;
    
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
    
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SkillMatch> createMatch(@RequestParam Long offerId, 
                                                  @RequestParam Long requestId, 
                                                  @RequestParam Long adminUserId) {
        SkillMatch match = matchService.createMatch(offerId, requestId, adminUserId);
        return ResponseEntity.ok(match);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SkillMatch>> getAllMatches() {
        List<SkillMatch> matches = matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillMatch> getMatch(@PathVariable Long id) {
        SkillMatch match = matchService.getMatch(id);
        return ResponseEntity.ok(match);
    }
    
    @PutMapping("/{id}/status")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SkillMatch> updateMatchStatus(@PathVariable Long id, @RequestParam String status) {
        SkillMatch match = matchService.updateMatchStatus(id, status);
        return ResponseEntity.ok(match);
    }
    
    @GetMapping("/offer/{offerId}")
    public ResponseEntity<List<SkillMatch>> getMatchesByOffer(@PathVariable Long offerId) {
        List<SkillMatch> matches = matchService.getMatchesByOffer(offerId);
        return ResponseEntity.ok(matches);
    }
    
    @GetMapping("/request/{requestId}")
    public ResponseEntity<List<SkillMatch>> getMatchesByRequest(@PathVariable Long requestId) {
        List<SkillMatch> matches = matchService.getMatchesByRequest(requestId);
        return ResponseEntity.ok(matches);
    }
}