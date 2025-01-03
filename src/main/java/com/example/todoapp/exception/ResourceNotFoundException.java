package com.example.todoapp.exception;

// Esta excepción extiende RuntimeException
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
