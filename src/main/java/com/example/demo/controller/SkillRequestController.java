package com.example.barter.controller;

import com.example.barter.model.SkillRequest;
import com.example.barter.service.SkillRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class SkillRequestController {

    private final SkillRequestService requestService;

    public SkillRequestController(SkillRequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<SkillRequest> create(@RequestBody SkillRequest request) {
        return ResponseEntity.ok(requestService.createRequest(request));
    }

    @GetMapping
    public ResponseEntity<List<SkillRequest>> getAll() {
        return ResponseEntity.ok(requestService.getOpenRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillRequest> get(@PathVariable Long id) {
        return ResponseEntity.ok(requestService.getRequest(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillRequest>> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(requestService.getRequestsByUser(userId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SkillRequest>> byCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(requestService.getRequestsByCategory(categoryId));
    }

    @GetMapping("/open")
    public ResponseEntity<List<SkillRequest>> open() {
        return ResponseEntity.ok(requestService.getOpenRequests());
    }
}
