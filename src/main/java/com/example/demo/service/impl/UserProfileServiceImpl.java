package com.example.demo.service.impl;

import com.example.demo.model.UserProfile;
import com.example.demo.service.UserProfileService;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {
    @Override
    public UserProfile createUser(UserProfile profile) {
        return profile; // Note: In a real app, call repository.save(profile)
    }

    @Override
    public UserProfile getUserById(Long id) {
        return new UserProfile();
    }

    @Override
    public void deactivateUser(Long id) {
        // Implementation logic
    }
}