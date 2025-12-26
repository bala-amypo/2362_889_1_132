package com.example.barter.controller;

import com.example.barter.model.SkillRequest;
import com.example.barter.service.SkillRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Request", description = "Skill request management endpoints")
public class SkillRequestController {
    
    private final SkillRequestService skillRequestService;
    
    public SkillRequestController(SkillRequestService skillRequestService) {
        this.skillRequestService = skillRequestService;
    }
    
    @PostMapping("/")
    public ResponseEntity<SkillRequest> createRequest(@RequestBody SkillRequest request) {
        SkillRequest savedRequest = skillRequestService.createRequest(request);
        return ResponseEntity.ok(savedRequest);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SkillRequest>> getAllRequests() {
        // Implementation would need SkillRequestService.getAllRequests() method
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillRequest> getRequest(@PathVariable Long id) {
        SkillRequest request = skillRequestService.getRequest(id);
        return ResponseEntity.ok(request);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SkillRequest>> getRequestsByUser(@PathVariable Long userId) {
        List<SkillRequest> requests = skillRequestService.getRequestsByUser(userId);
        return ResponseEntity.ok(requests);
    }
    
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<SkillRequest>> getRequestsByCategory(@PathVariable Long categoryId) {
        List<SkillRequest> requests = skillRequestService.getRequestsByCategory(categoryId);
        return ResponseEntity.ok(requests);
    }
    
    @GetMapping("/open")
    public ResponseEntity<List<SkillRequest>> getOpenRequests() {
        List<SkillRequest> requests = skillRequestService.getOpenRequests();
        return ResponseEntity.ok(requests);
    }
}