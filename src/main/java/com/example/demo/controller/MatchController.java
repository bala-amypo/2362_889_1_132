package com.example.barter.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/matches")
@Tag(name = "Match", description = "Skill match management endpoints")
public class MatchController {

    @GetMapping("/")
    public ResponseEntity<String> getAllMatches() {
        return ResponseEntity.ok("All matches endpoint");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getMatch(@PathVariable Long id) {
        return ResponseEntity.ok("Match with ID: " + id);
    }
}