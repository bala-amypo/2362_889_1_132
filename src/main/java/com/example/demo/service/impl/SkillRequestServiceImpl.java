package com.example.demo.service.impl;

import com.example.demo.model.SkillRequest;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.service.SkillRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillRequestServiceImpl implements SkillRequestService {

    private final SkillRequestRepository skillRequestRepository;

    public SkillRequestServiceImpl(SkillRequestRepository skillRequestRepository) {
        this.skillRequestRepository = skillRequestRepository;
    }

    @Override
    public SkillRequest createSkillRequest(SkillRequest request) {
        // ❌ DO NOT set ID manually
        // JPA will auto-generate it
        return skillRequestRepository.save(request);
    }

    @Override
    public List<SkillRequest> getAllSkillRequests() {
        return skillRequestRepository.findAll();
    }

    @Override
    public SkillRequest getSkillRequestById(Long id) {
        return skillRequestRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SkillRequest not found with id: " + id));
    }

    @Override
    public void deleteSkillRequest(Long id) {
        skillRequestRepository.deleteById(id);
    }
}
