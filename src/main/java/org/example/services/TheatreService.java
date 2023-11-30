package org.example.services;

import org.example.exceptions.NotFoundException;
import org.example.models.Screen;
import org.example.models.Seat;
import org.example.models.Theatre;

import java.util.HashMap;
import java.util.UUID;

public class TheatreService {

    private static String THEATRE_CONST = "theatre" ;
    private static String SCREEN_CONST = "screen" ;
    private final HashMap<String, Theatre> theatres ;
    private final HashMap<String, Screen> screens ;

    public TheatreService() {
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
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

    public Screen getScreen(String screenId) {
        if (!screens.containsKey(screenId)) {
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
        screen.addSeats(newSeat);
        return newSeat ;
    }
}
