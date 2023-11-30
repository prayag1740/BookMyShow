package org.example.services;

import org.example.exceptions.NotFoundException;
import org.example.models.Movie;

import java.util.HashMap;

public class MovieService {

    private HashMap<String, Movie> movies ;
    private  static String MOVIE_CONST = "movies" ;

    public MovieService() {
        this.movies = new HashMap<>() ;
    }

    public Movie getMovie(String movieId) {
        if (!this.movies.containsKey(movieId)) {
            throw new NotFoundException(MOVIE_CONST) ;
        }
        return this.movies.get(movieId) ;
    }

}
