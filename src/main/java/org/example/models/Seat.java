package org.example.models;

public class Seat {
    private String id ;
    private Integer rowNo ;
    private Integer seatNo ;
    public Seat(String id, Integer rowNo, Integer seatNo) {
        this.id = id ;
        this.rowNo = rowNo ;
        this.seatNo = seatNo ;
    }

    public String getId() {
        return id;
    }
}
