package org.example.exceptions;

public class InvalidBookingStatus extends RuntimeException {

    public InvalidBookingStatus() {
        super("Invalid Booking Status");
    }
}
