package org.example.exceptions;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException () {
        super("Invalid Email Exception");
    }
}
