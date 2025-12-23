package com.example.barter.service.impl;

import com.example.barter.exception.BadRequestException;
import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.SkillOffer;
import com.example.barter.repository.SkillOfferRepository;
import com.example.barter.service.SkillOfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillOfferServiceImpl implements SkillOfferService {

    private final SkillOfferRepository repository;

    public SkillOfferServiceImpl(SkillOfferRepository repository) {
        this.repository = repository;
    }

    @Override
    public SkillOffer createOffer(SkillOffer offer) {
        if (offer.getSkillName().length() < 5) {
            throw new BadRequestException(
                    "Skill name must be at least 5 characters");
        }
        return repository.save(offer);
    }

    @Override
    public SkillOffer getOffer(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Offer not found"));
    }

    @Override
    public List<SkillOffer> getOffersByUser(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<SkillOffer> getOffersByCategory(Long categoryId) {
        return repository.findBySkillCategoryId(categoryId);
    }

    @Override
    public List<SkillOffer> getAvailableOffers() {
        return repository.findByAvailability("AVAILABLE");
    }
}
