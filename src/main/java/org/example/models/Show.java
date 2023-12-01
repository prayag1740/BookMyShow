package org.example.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Show {

    private final String id ;

    private final Movie movie ;
    private final Screen screen;
    private final LocalDateTime startTime ;
    private final Integer duration ;

    public Show(String id, Movie movie, Screen screen, LocalDateTime startTime, Integer duration) {
        this.id = id ;
        this.movie = movie ;
        this.screen = screen ;
        this.startTime = startTime ;
        this.duration = duration ;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getId() {
        return id;
    }

    public Screen getScreen() {
        return screen;
    }
}
