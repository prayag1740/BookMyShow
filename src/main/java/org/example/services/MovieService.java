package org.example.services;

import org.example.exceptions.NotFoundException;
import org.example.models.Movie;

import java.util.HashMap;
import java.util.UUID;

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

    public Movie createMovie(String name) {
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, name) ;
        this.movies.put(movieId, movie) ;
        return movie ;
    }

}
