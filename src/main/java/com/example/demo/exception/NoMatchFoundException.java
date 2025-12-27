package com.example.demo.exception;

public class NoMatchFoundException extends RuntimeException {
    public NoMatchFoundException() {
        super("No match found");
    }
}