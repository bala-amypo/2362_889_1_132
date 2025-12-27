package com.example.demo.exception;

public class UserProfileNotFoundException extends RuntimeException {
    public UserProfileNotFoundException() {
        super("UserProfile not found");
    }
}