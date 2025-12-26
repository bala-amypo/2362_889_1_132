package com.example.barter.controller;

import com.example.barter.model.User;
import com.example.barter.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "User management endpoints")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }
    
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        // Implementation would need UserService.getAllUsers() method
        return ResponseEntity.ok().build();
    }
    
    @PutMapping("/{id}/rating")
    public ResponseEntity<User> updateRating(@PathVariable Long id, @RequestParam double rating) {
        User user = userService.updateRating(id, rating);
        return ResponseEntity.ok(user);
    }
}