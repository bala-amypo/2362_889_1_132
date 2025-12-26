package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.BarterTransaction;
import com.example.barter.model.SkillMatch;
import com.example.barter.repository.BarterTransactionRepository;
import com.example.barter.repository.SkillMatchRepository;
import com.example.barter.service.TransactionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    
    private final BarterTransactionRepository barterTransactionRepository;
    private final SkillMatchRepository skillMatchRepository;
    
    public TransactionServiceImpl(BarterTransactionRepository barterTransactionRepository, SkillMatchRepository skillMatchRepository) {
        this.barterTransactionRepository = barterTransactionRepository;
        this.skillMatchRepository = skillMatchRepository;
    }
    
    @Override
    public BarterTransaction createTransaction(Long matchId) {
        SkillMatch match = skillMatchRepository.findById(matchId)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found"));
        
        BarterTransaction transaction = new BarterTransaction(match);
        try {
            return barterTransactionRepository.save(transaction);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Transaction not found");
        }
    }
    
    @Override
    public BarterTransaction getTransaction(Long id) {
        return barterTransactionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }
    
    @Override
    public List<BarterTransaction> getAllTransactions() {
        return barterTransactionRepository.findAll();
    }
    
    @Override
    public BarterTransaction completeTransaction(Long transactionId, Integer offererRating, Integer requesterRating) {
        BarterTransaction transaction = getTransaction(transactionId);
        transaction.setStatus("COMPLETED");
        transaction.setOffererRating(offererRating);
        transaction.setRequesterRating(requesterRating);
        transaction.setCompletedAt(LocalDateTime.now());
        return barterTransactionRepository.save(transaction);
    }
    
    @Override
    public List<BarterTransaction> getTransactionsByStatus(String status) {
        return barterTransactionRepository.findByStatus(status);
    }
}