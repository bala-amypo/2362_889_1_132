package com.example.demo.service;

import com.example.demo.model.SkillRequest;

public interface SkillRequestService {

    SkillRequest create(SkillRequest request);

    SkillRequest getRequestById(long id);
}
