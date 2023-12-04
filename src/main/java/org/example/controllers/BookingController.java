package org.example.controllers;

import org.example.models.Booking;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.models.User;
import org.example.services.BookingService;
import org.example.services.ShowService;
import org.example.services.TheatreService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingController {

    private final BookingService bookingService ;
    private final ShowService showService ;
    private final TheatreService theatreService ;

    public BookingController( BookingService bookingService, TheatreService theatreService, ShowService showService) {
        this.bookingService = bookingService ;
        this.showService = showService;
        this.theatreService = theatreService;
    }

    public String createBooking(User user, String showId, List<String> seatIds) {
        String bookingId = UUID.randomUUID().toString();
        List<Seat> seatsBooked = new ArrayList<>() ;
        for (String s : seatIds) {
            Seat orgSeat = theatreService.getSeat(s);
            seatsBooked.add(orgSeat);
        }
        Show show = showService.getShow(showId) ;
        return bookingService.createBooking(show, user, seatsBooked).getId() ;
    }

    public List<Booking> getAllBookings(String showId) {
        Show show = showService.getShow(showId) ;
        return bookingService.getAllBooking(show) ;
    }


}
