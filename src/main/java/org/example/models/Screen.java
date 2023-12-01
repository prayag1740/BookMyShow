package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String id ;
    private final String name ;
    private  List<Seat> seats ;
    private final List<Show> shows ;
    private final Theatre theatre;

    public Screen(String id, String name, Theatre theatre) {
        this.id = id ;
        this.name = name ;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public void addSeats(Seat seat) {
        this.seats.add(seat) ;
    }

    public String getId() {
        return id;
    }

    public List<Show> getShows() {
        return shows;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
