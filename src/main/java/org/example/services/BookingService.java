package org.example.services;

import org.example.exceptions.NotFoundException;
import org.example.exceptions.SeatUnavailableException;
import org.example.models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BookingService {

    private HashMap<String, Booking> allbookings ;
    private static String MOVIE_CONST = "Movie" ;

    public BookingService() {
        this.allbookings = new HashMap<>();
    }

    public Booking getBooking(String bookingId) {
        if (!this.allbookings.containsKey(bookingId)) {
            throw new NotFoundException(MOVIE_CONST) ;
        }
        return this.allbookings.get(bookingId) ;
    }

    public List<Booking> getAllBooking(Show show) {
        List<Booking> showBooking = new ArrayList<>() ;
        for (Booking booking : this.allbookings.values()) {
            if (booking.getShow().equals(show)) {
                showBooking.add(booking);
            }
        }
        return showBooking ;
    }

    public List<Seat> getBookedSeats(Show show) {
        List<Seat> showSeats = new ArrayList<>();
        List<Booking> showBookings = getAllBooking(show) ;
        for (Booking booking : showBookings) {
            if (booking.getBookingStatus() == BookingStatus.Confimed) {
                showSeats.addAll(booking.getSeatsBooked());
            }
        }
        return showSeats ;
    }

    public Booking createBooking(Show show, User user, List<Seat> seatsBooked) {
        if (ifAnySeatAlreadyBooked(show, seatsBooked)) {
            throw new SeatUnavailableException();
        }
        String bookingID = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingID, show, user, seatsBooked) ;
        this.allbookings.put(bookingID, booking) ;
        return booking ;
        //TODO : create timer for booking expiry
    }

    private boolean ifAnySeatAlreadyBooked(Show show, List<Seat> seats) {
        List<Seat> bookedSeats = getBookedSeats(show) ;
        for (Seat s : seats) {
            if (bookedSeats.contains(s)) {
                return true ;
            }
        }
        return false ;
    }

}
