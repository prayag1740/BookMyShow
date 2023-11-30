package org.example.controllers;

import org.example.models.Movie;
import org.example.models.Screen;
import org.example.services.MovieService;
import org.example.services.ShowService;
import org.example.services.TheatreService;

import java.time.LocalDateTime;

public class ShowController {
    private  ShowService showService = new ShowService() ;
    private TheatreService theatreService = new TheatreService();
    private MovieService movieService = new MovieService();

    public String createShow(String movieId, String screenId, LocalDateTime startTime, Integer duration) {
        Screen screen = theatreService.getScreen(screenId) ;
        Movie movie = movieService.getMovie(movieId) ;
        return showService.createShow(movie, screen, startTime, duration).getId() ;
    }


}
