package org.example.controllers;

import org.example.models.Screen;
import org.example.models.Theatre;
import org.example.services.TheatreService;

public class TheatreController {

    private final TheatreService theatreService = new TheatreService();
    private String createTheatre(String theatreName) {
        return theatreService.createTheatre(theatreName).getId();
    }
    private String createScreenInTheatre(String screenName, String theatreId) {
        Theatre theatre = theatreService.getTheatre(theatreId) ;
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }
    private String createSeatInScreen(Integer rowNo, Integer seatNo, String screenId) {
        Screen screen = theatreService.getScreen(screenId) ;
        return theatreService.createSeatInScreen(rowNo, seatNo, screen).getId() ;
    }
}
