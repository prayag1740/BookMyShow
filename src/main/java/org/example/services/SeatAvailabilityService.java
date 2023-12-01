package org.example.services;

import org.example.models.Seat;
import org.example.models.Show;

import java.util.List;

public class SeatAvailabilityService {

    private BookingService bookingService = new BookingService();

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> allSeats = show.getScreen().getSeats() ;
        List<Seat> unAvailableSeats = getUnavailableSeats(show);
        allSeats.removeAll(unAvailableSeats) ;
        return allSeats ;
    }

    public List<Seat> getUnavailableSeats(Show show) {
        List<Seat> bookedSeats = bookingService.getBookedSeats(show) ;
        // TODO : Add SeatLockerProvider
        return bookedSeats ;
    }

}
