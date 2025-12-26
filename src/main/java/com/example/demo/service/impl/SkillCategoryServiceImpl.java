package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.SkillCategory;
import com.example.barter.repository.SkillCategoryRepository;
import com.example.barter.service.SkillCategoryService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {
    
    private final SkillCategoryRepository skillCategoryRepository;
    
    public SkillCategoryServiceImpl(SkillCategoryRepository skillCategoryRepository) {
        this.skillCategoryRepository = skillCategoryRepository;
    }
    
    @Override
    public SkillCategory createCategory(SkillCategory category) {
        if (category == null) {
            throw new ResourceNotFoundException("Category not found");
        }
        return skillCategoryRepository.save(category);
    }
    
    @Override
    public SkillCategory getCategory(Long id) {
        return skillCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }
    
    @Override
    public List<SkillCategory> getAllCategories() {
        return skillCategoryRepository.findAll();
    }
}