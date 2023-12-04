package org.example.services;

import org.example.exceptions.NotFoundException;
import org.example.models.Screen;
import org.example.models.Seat;
import org.example.models.Theatre;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TheatreService {
    private static String THEATRE_CONST = "theatre" ;
    private static String SCREEN_CONST = "screen" ;
    private static String SEAT_CONST = "seat" ;
    private final HashMap<String, Theatre> theatres ;
    private final HashMap<String, Screen> screens ;
    private final HashMap<String, Seat> seats ;

    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
    }

    public Theatre createTheatre(String theatreName) {
        String theatreId = UUID.randomUUID().toString();
        Theatre theatre = new Theatre(theatreId, theatreName);
        this.theatres.put(theatreId, theatre);
        return theatre;
    }

    public Theatre getTheatre(String theatreId) {
        if (! this.theatres.containsKey(theatreId)) {
            throw new NotFoundException(THEATRE_CONST);
        }
        return theatres.get(theatreId);
    }

    public Seat getSeat(String seatId) {
        if (! this.seats.containsKey(seatId)) {
            throw new NotFoundException(SEAT_CONST) ;
        }
        return this.seats.get(seatId) ;
    }

    public Screen getScreen(String screenId) {
        if (!this.screens.containsKey(screenId)) {
            throw new NotFoundException(SCREEN_CONST);
        }
        return screens.get(screenId);
    }

    public Screen createScreenInTheatre(String screenName, Theatre theatre) {
        Screen newScreen = createScreen(screenName, theatre);
        theatre.addScreens(newScreen);
        this.screens.put(newScreen.getId(), newScreen);
        return newScreen;
    }
    public Screen createScreen(String screenName, Theatre theatre) {
        String screenId = UUID.randomUUID().toString();
        return new Screen(screenId, screenName, theatre);
    }

    public Seat createSeatInScreen(Integer rowNo, Integer seatNo, Screen screen) {
        String seatId = UUID.randomUUID().toString();
        Seat newSeat = new Seat(seatId, rowNo, seatNo) ;
        this.seats.put(seatId, newSeat) ;
        screen.addSeats(newSeat);
        return newSeat ;
    }

    public List<Seat> getAllSeatsforScreen(Screen screen) {
        System.out.println("debuggg " + this.seats.size());
        System.out.println("debuggg2 " + screen.getSeats().size());
        return screen.getSeats();
    }
}
