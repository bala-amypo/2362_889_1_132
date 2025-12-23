package com.example.barter.controller;

import com.example.barter.model.SkillMatch;
import com.example.barter.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public ResponseEntity<SkillMatch> create(
            @RequestParam Long offerId,
            @RequestParam Long requestId,
            @RequestParam Long adminUserId) {
        return ResponseEntity.ok(
                matchService.createMatch(offerId, requestId, adminUserId)
        );
    }

    @GetMapping
    public ResponseEntity<List<SkillMatch>> all() {
        return ResponseEntity.ok(matchService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillMatch> get(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatch(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<SkillMatch> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(matchService.updateMatchStatus(id, status));
    }
}
