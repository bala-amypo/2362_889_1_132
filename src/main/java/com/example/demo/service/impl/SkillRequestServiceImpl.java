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
    public SkillRequest createRequest(SkillRequest request) {
        return skillRequestRepository.save(request);
    }

    @Override
    public SkillRequest getRequestById(long id) {
        return skillRequestRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("SkillRequest not found with id: " + id));
    }

    @Override
    public List<SkillRequest> getAllRequests() {
        return skillRequestRepository.findAll();
    }

    @Override
    public SkillRequest updateRequest(long id, SkillRequest request) {
        SkillRequest existing = getRequestById(id);
        existing.setSkillName(request.getSkillName()); // adjust fields as needed
        existing.setDescription(request.getDescription());
        return skillRequestRepository.save(existing);
    }

    @Override
    public void deleteRequest(long id) {
        skillRequestRepository.deleteById(id);
    }
}
