package com.furnapp.exceptions;

public class FurnitureNotFoundException extends RuntimeException {
    public FurnitureNotFoundException() {
    }

    public FurnitureNotFoundException(String message) {
        super(message);
    }
}
