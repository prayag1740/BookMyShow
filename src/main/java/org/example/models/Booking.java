package org.example.models;

import org.example.exceptions.InvalidBookingStatus;

import java.util.List;

public class Booking {

    private final String id ;
    private final Show show ;
    private final User user ;
    private List<Seat> seatsBooked ;
    private BookingStatus bookingStatus;

    public Booking(String id, Show show, User user, List<Seat> seatsBooked) {
        this.id = id ;
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

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeatsBooked() {
        return seatsBooked;
    }

    public String getId() {
        return id;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
