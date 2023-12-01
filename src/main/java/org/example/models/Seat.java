package org.example.models;

public class Seat {
    private final String id ;
    private final Integer rowNo ;
    private final Integer seatNo ;
    public Seat(String id, Integer rowNo, Integer seatNo) {
        this.id = id ;
        this.rowNo = rowNo ;
        this.seatNo = seatNo ;
    }

    public String getId() {
        return id;
    }
}
