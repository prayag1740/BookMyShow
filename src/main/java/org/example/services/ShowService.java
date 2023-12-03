package org.example.services;

import org.example.exceptions.NotFoundException;
import org.example.exceptions.SlotAlreadyOccupiedException;
import org.example.models.Movie;
import org.example.models.Screen;
import org.example.models.Show;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ShowService {

    private static String SHOW_CONST = "shows" ;
    private final HashMap<String, Show> shows ;

    public ShowService() {
        this.shows = new HashMap<>();
    }

    public Show getShow(String showID) {
        if (!this.shows.containsKey(showID)) {
            throw new NotFoundException(SHOW_CONST);
        }
        return this.shows.get(showID) ;
    }

    public Show createShow(Movie movie, Screen screen, LocalDateTime startTime, Integer duration) {
        if (!isShowCreationAllowed(screen, startTime)) {
            throw new SlotAlreadyOccupiedException();
        }
        String showId = UUID.randomUUID().toString();
        Show show = new Show(showId, movie, screen, startTime, duration) ;
        this.shows.put(showId, show) ;
        return show ;
    }

    public List<Show> getShowsForScreen(Screen screen) {
        return screen.getShows();
    }

    private boolean isShowCreationAllowed(Screen screen, LocalDateTime startTime) {
        List<Show> allShows = screen.getShows();
        for (Show show: allShows) {
            if (show.getStartTime().isEqual(startTime)) {
                return false ;
            }
        }
        return true;
    }



}
