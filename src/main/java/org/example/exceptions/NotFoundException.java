package org.example.exceptions;

public class NotFoundException extends RuntimeException {
    String entity ;
    public NotFoundException(String entity) {
        super("Not found " + entity) ;
    }
}
