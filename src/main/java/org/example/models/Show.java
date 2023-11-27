package org.example.models;

import java.time.LocalTime;

public class Show {

    private Movie movie ;
    private Screen screen;
    private LocalTime startTime ;
    private Integer durationInMinutes ;

    public Show(Movie movie, Screen screen, LocalTime startTime, Integer durationInMinutes) {
        this.movie = movie ;
        this.screen = screen ;
        this.startTime = startTime ;
        this.durationInMinutes = durationInMinutes ;
    }



}
