package org.example.ecomsite.exception;

public class CategoryAlreadyFoundException extends RuntimeException {
    public CategoryAlreadyFoundException(String message) {
        super(message);
    }
}
