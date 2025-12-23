package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.SkillMatch;
import com.example.barter.repository.SkillMatchRepository;
import com.example.barter.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {

    private final SkillMatchRepository repository;

    public MatchServiceImpl(SkillMatchRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillMatch createMatch(Long offerId, Long requestId, Long adminUserId) {
        SkillMatch match = new SkillMatch();
        return repository.save(match);
    }

    @Override
    public SkillMatch getMatch(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Match not found"));
    }

    @Override
    public List<SkillMatch> getAllMatches() {
        return repository.findAll();
    }

    @Override
    public SkillMatch updateMatchStatus(Long matchId, String status) {
        SkillMatch match = getMatch(matchId);
        match.setMatchStatus(status);
        return repository.save(match);
    }
}
