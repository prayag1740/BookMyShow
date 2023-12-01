package org.example.exceptions;

public class SeatUnavailableException extends RuntimeException {
    public SeatUnavailableException() {
        super("Seat is unavailable || Booking cannot be completed");
    }
}
