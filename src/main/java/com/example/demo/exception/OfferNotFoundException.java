package com.example.demo.exception;

public class OfferNotFoundException extends RuntimeException {
    public OfferNotFoundException() {
        super("Offer not found");
    }
}
