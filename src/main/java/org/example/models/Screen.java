package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    Integer id ;
    String name ;
    List<Seat> seats ;

    public Screen(Integer id, String name) {
        this.id = id ;
        this.name = name ;
        this.seats = new ArrayList<>();
    }

    public void addSeats(Seat seat) {
        this.seats.add(seat) ;
    }
}
