package org.example.controllers;

import org.example.models.Movie;
import org.example.services.MovieService;

import java.util.UUID;

public class MovieController {

    private final MovieService movieService ;

    public MovieController(MovieService movieService) {
        this.movieService = movieService ;
    }

    public String createMovie(String movieName) {
        return movieService.createMovie(movieName).getId();
    }

}
