package com.pmoran.devsu.service.cuenta.error;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
