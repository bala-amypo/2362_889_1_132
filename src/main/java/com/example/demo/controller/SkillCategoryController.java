package com.example.barter.controller;

import com.example.barter.model.SkillCategory;
import com.example.barter.service.SkillCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category", description = "Skill category management endpoints")
public class SkillCategoryController {
    
    private final SkillCategoryService skillCategoryService;
    
    public SkillCategoryController(SkillCategoryService skillCategoryService) {
        this.skillCategoryService = skillCategoryService;
    }
    
    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SkillCategory> createCategory(@RequestBody SkillCategory category) {
        SkillCategory savedCategory = skillCategoryService.createCategory(category);
        return ResponseEntity.ok(savedCategory);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<SkillCategory>> getAllCategories() {
        List<SkillCategory> categories = skillCategoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SkillCategory> getCategory(@PathVariable Long id) {
        SkillCategory category = skillCategoryService.getCategory(id);
        return ResponseEntity.ok(category);
    }
}