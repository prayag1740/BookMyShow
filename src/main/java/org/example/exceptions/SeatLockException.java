package org.example.exceptions;

public class SeatLockException extends RuntimeException {
    public SeatLockException() {
        super("There is a seat lock exception !!");
    }
}
