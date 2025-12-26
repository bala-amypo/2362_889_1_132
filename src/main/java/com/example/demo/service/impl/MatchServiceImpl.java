package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.SkillMatch;
import com.example.demo.model.SkillOffer;
import com.example.demo.model.SkillRequest;
import com.example.demo.model.User;
import com.example.demo.repository.SkillMatchRepository;
import com.example.demo.repository.SkillOfferRepository;
import com.example.demo.repository.SkillRequestRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.MatchService;
import com.example.demo.util.SkillMatchingEngine;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    
    private final SkillMatchRepository skillMatchRepository;
    private final SkillOfferRepository skillOfferRepository;
    private final SkillRequestRepository skillRequestRepository;
    private final UserRepository userRepository;
    private final SkillMatchingEngine skillMatchingEngine;
    
    public MatchServiceImpl(SkillMatchRepository skillMatchRepository, 
                           SkillOfferRepository skillOfferRepository,
                           SkillRequestRepository skillRequestRepository,
                           UserRepository userRepository,
                           SkillMatchingEngine skillMatchingEngine) {
        this.skillMatchRepository = skillMatchRepository;
        this.skillOfferRepository = skillOfferRepository;
        this.skillRequestRepository = skillRequestRepository;
        this.userRepository = userRepository;
        this.skillMatchingEngine = skillMatchingEngine;
    }
    
    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillOffer offer = skillOfferRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("Offer not found"));
        SkillRequest request = skillRequestRepository.findById(requestId)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        User admin = userRepository.findById(adminUserId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        double matchScore = skillMatchingEngine.calculateMatchScore(offer, request);
        SkillMatch match = new SkillMatch(offer, request, admin, matchScore);
        
        try {
            return skillMatchRepository.save(match);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Match not found");
        }
    }
    
    @Override
    public SkillMatch getMatch(Long id) {
        return skillMatchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
    }
    
    @Override
    public List<SkillMatch> getAllMatches() {
        return skillMatchRepository.findAll();
    }
    
    @Override
    public SkillMatch updateMatchStatus(Long matchId, String status) {
        SkillMatch match = getMatch(matchId);
        match.setMatchStatus(status);
        return skillMatchRepository.save(match);
    }
    
    @Override
    public List<SkillMatch> getMatchesByOffer(Long offerId) {
        return skillMatchRepository.findByOfferId(offerId);
    }
    
    @Override
    public List<SkillMatch> getMatchesByRequest(Long requestId) {
        return skillMatchRepository.findByRequestId(requestId);
    }
}