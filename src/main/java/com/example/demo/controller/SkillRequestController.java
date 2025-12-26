package com.example.demo.controller;

import com.example.demo.model.SkillRequest;
import com.example.demo.service.SkillRequestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class SkillRequestController {

    private final SkillRequestService service;

    public SkillRequestController(SkillRequestService service) {
        this.service = service;
    }

    @PostMapping
    public SkillRequest create(@RequestBody SkillRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public SkillRequest getRequestById(@PathVariable long id) {
        return service.getRequestById(id);
    }
}
