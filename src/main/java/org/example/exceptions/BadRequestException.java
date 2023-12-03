package org.example.exceptions;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Bad Request Exception");
    }
}
