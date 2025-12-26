package com.example.demo.controller;

import com.example.demo.model.BarterTransaction;
import com.example.demo.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction", description = "Barter transaction management endpoints")
public class TransactionController {
    
    private final TransactionService transactionService;
    
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    
    @PostMapping("/")
    public ResponseEntity<BarterTransaction> createTransaction(@RequestParam Long matchId) {
        BarterTransaction transaction = transactionService.createTransaction(matchId);
        return ResponseEntity.ok(transaction);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<BarterTransaction>> getAllTransactions() {
        List<BarterTransaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BarterTransaction> getTransaction(@PathVariable Long id) {
        BarterTransaction transaction = transactionService.getTransaction(id);
        return ResponseEntity.ok(transaction);
    }
    
    @PutMapping("/{id}/complete")
    public ResponseEntity<BarterTransaction> completeTransaction(@PathVariable Long id,
                                                                @RequestParam Integer offererRating,
                                                                @RequestParam Integer requesterRating) {
        BarterTransaction transaction = transactionService.completeTransaction(id, offererRating, requesterRating);
        return ResponseEntity.ok(transaction);
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<BarterTransaction>> getTransactionsByStatus(@PathVariable String status) {
        List<BarterTransaction> transactions = transactionService.getTransactionsByStatus(status);
        return ResponseEntity.ok(transactions);
    }
}