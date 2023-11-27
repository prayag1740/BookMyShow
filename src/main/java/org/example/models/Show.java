package org.example.models;

public class Show {

    private Movie movie ;
    private Screen screen;
    private String startTime ;
    private Integer durationInMinutes ;

    public Show(Movie movie, Screen screen, String startTime, Integer durationInMinutes) {
        this.movie = movie ;
        this.screen = screen ;
        this.startTime = startTime ;
        this.durationInMinutes = durationInMinutes ;
    }



}
