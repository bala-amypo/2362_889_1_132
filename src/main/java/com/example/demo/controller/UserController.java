package com.example.barter.controller;

import com.example.barter.model.User;
import com.example.barter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}/rating")
    public ResponseEntity<User> updateRating(
            @PathVariable Long id,
            @RequestParam double rating) {
        return ResponseEntity.ok(userService.updateRating(id, rating));
    }
}
