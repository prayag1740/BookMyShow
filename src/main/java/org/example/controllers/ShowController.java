package org.example.controllers;

import org.example.models.Movie;
import org.example.models.Screen;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.services.MovieService;
import org.example.services.SeatAvailabilityService;
import org.example.services.ShowService;
import org.example.services.TheatreService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowController {
    private  ShowService showService = new ShowService() ;
    private TheatreService theatreService = new TheatreService();
    private MovieService movieService = new MovieService();

    private SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService();

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
