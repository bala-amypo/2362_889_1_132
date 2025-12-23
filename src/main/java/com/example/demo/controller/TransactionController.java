package com.example.barter.controller;

import com.example.barter.model.BarterTransaction;
import com.example.barter.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<BarterTransaction> create(@RequestParam Long matchId) {
        return ResponseEntity.ok(transactionService.createTransaction(matchId));
    }

    @GetMapping
    public ResponseEntity<List<BarterTransaction>> all() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BarterTransaction> get(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getTransaction(id));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<BarterTransaction> complete(
            @PathVariable Long id,
            @RequestParam Integer offererRating,
            @RequestParam Integer requesterRating) {
        return ResponseEntity.ok(
                transactionService.completeTransaction(id, offererRating, requesterRating)
        );
    }
}
