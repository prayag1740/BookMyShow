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

    public Seat(Seat original) {
        this.id = original.id ;
        this.rowNo = original.rowNo;
        this.seatNo = original.seatNo ;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "seatId-" + this.id;
    }
}
