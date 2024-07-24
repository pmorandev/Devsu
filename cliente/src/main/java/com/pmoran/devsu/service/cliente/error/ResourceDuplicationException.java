package com.pmoran.devsu.service.cliente.error;

public class ResourceDuplicationException extends RuntimeException {

    public ResourceDuplicationException(String message) {
        super(message);
    }

    public ResourceDuplicationException(String message, Throwable cause) {
        super(message, cause);
    }

}
