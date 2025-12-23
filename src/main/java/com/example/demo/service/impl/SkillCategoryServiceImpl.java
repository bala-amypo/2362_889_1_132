package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.SkillCategory;
import com.example.barter.repository.SkillCategoryRepository;
import com.example.barter.service.SkillCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {

    private final SkillCategoryRepository repository;

    public SkillCategoryServiceImpl(SkillCategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillCategory createCategory(SkillCategory category) {
        return repository.save(category);
    }

    @Override
    public SkillCategory getCategory(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Category not found"));
    }

    @Override
    public List<SkillCategory> getAllCategories() {
        return repository.findAll();
    }
}
