package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String id ;
    private String name ;
    List<Seat> seats ;
    private Theatre theatre;

    public Screen(String id, String name, Theatre theatre) {
        this.id = id ;
        this.name = name ;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public void addSeats(Seat seat) {
        this.seats.add(seat) ;
    }
}
