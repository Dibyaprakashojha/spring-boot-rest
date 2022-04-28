package com.bookapp.exceptions;

import lombok.AllArgsConstructor;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
