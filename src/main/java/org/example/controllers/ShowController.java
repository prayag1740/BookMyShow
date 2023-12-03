package org.example.controllers;

import org.example.models.Movie;
import org.example.models.Screen;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.providers.SeatLockProvider;
import org.example.services.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowController {
    private  final ShowService showService ;
    private final TheatreService theatreService ;
    private final MovieService movieService ;
    private final SeatAvailabilityService seatAvailabilityService ;

    public ShowController(ShowService showService, TheatreService theatreService, SeatAvailabilityService seatAvailabilityService, MovieService movieService ) {
        this.showService = showService;
        this.theatreService = theatreService;
        this.movieService = movieService;
        this.seatAvailabilityService = seatAvailabilityService ;
    }

    public String createShow(String movieId, String screenId, LocalDateTime startTime, Integer duration) {
        Screen screen = theatreService.getScreen(screenId) ;
        Movie movie = movieService.getMovie(movieId) ;
        return showService.createShow(movie, screen, startTime, duration).getId() ;
    }

    public List<String> getAvailableSeats(String showId) {
        Show show = showService.getShow(showId) ;
        List<Seat> availableSeats = seatAvailabilityService.getAvailableSeats(show) ;
        List<String> seatIds = new ArrayList<>() ;
        for (Seat seat : availableSeats) {
            seatIds.add(seat.getId());
        }
        return seatIds ;
    }




}
