package org.example.services;

import org.example.models.Seat;
import org.example.models.Show;
import org.example.providers.SeatLockProvider;

import java.util.List;

public class SeatAvailabilityService {

    private final SeatLockProvider seatLockProvider ;

    private final BookingService bookingService ;

    public SeatAvailabilityService(SeatLockProvider seatLockProvider) {
        this.seatLockProvider = seatLockProvider ;
        this.bookingService = new BookingService(seatLockProvider) ;
    }

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> allSeats = show.getScreen().getSeats() ;
        List<Seat> unAvailableSeats = getUnavailableSeats(show);
        allSeats.removeAll(unAvailableSeats) ;
        return allSeats ;
    }

    public List<Seat> getUnavailableSeats(Show show) {
        List<Seat> bookedSeats = bookingService.getBookedSeats(show) ;
        bookedSeats.addAll(this.seatLockProvider.getLockedSeats(show)) ;
        return bookedSeats ;
    }

}
