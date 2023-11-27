package org.example.models;

import org.example.exceptions.InvalidBookingStatus;

import java.util.List;

public class Booking {
    private Show show ;
    private User user ;
    private List<Seat> seatsBooked ;
    private BookingStatus bookingStatus;

    public Booking(Show show, User user, List<Seat> seatsBooked, BookingStatus bookingStatus) {
        this.show = show ;
        this.user = user ;
        this.seatsBooked = seatsBooked;
        this.bookingStatus = BookingStatus.Created;
    }

    public void confirmBooking() {
        if (this.bookingStatus != BookingStatus.Created) {
            throw new InvalidBookingStatus();
        }
        this.bookingStatus = BookingStatus.Confimed ;
    }

    public void expireBooking() {
        if (this.bookingStatus != BookingStatus.Created) {
            throw new InvalidBookingStatus();
        }
        this.bookingStatus = BookingStatus.Expired;
    }
}
