package com.example.barter.service.impl;

import com.example.barter.exception.ResourceNotFoundException;
import com.example.barter.model.BarterTransaction;
import com.example.barter.repository.BarterTransactionRepository;
import com.example.barter.service.TransactionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final BarterTransactionRepository repository;

    public TransactionServiceImpl(BarterTransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public BarterTransaction createTransaction(Long matchId) {
        BarterTransaction tx = new BarterTransaction();
        return repository.save(tx);
    }

    @Override
    public BarterTransaction getTransaction(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Transaction not found"));
    }

    @Override
    public List<BarterTransaction> getAllTransactions() {
        return repository.findAll();
    }

    @Override
    public BarterTransaction completeTransaction(
            Long transactionId, Integer offererRating, Integer requesterRating) {

        BarterTransaction tx = getTransaction(transactionId);
        tx.setOffererRating(offererRating);
        tx.setRequesterRating(requesterRating);
        tx.setStatus("COMPLETED");
        tx.setCompletedAt(LocalDateTime.now());
        return repository.save(tx);
    }
}
