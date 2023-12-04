package org.example.scenarios;

import org.example.controllers.*;
import org.example.models.Seat;
import org.example.providers.InMemorySeatLockProvider;
import org.example.providers.SeatLockProvider;
import org.example.services.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseTest {

    protected BookingController bookingController ;
    protected MovieController movieController ;
    protected PaymentController paymentController ;
    protected ShowController showController ;
    protected TheatreController theatreController ;

    protected void setupControllers(final Integer lockTimeout) {
        final SeatLockProvider seatLockProvider = new InMemorySeatLockProvider(lockTimeout) ;
        final BookingService bookingService = new BookingService(seatLockProvider);
        final MovieService movieService = new MovieService();
        final PaymentService paymentService = new PaymentService(seatLockProvider) ;
        final SeatAvailabilityService seatAvailabilityService = new SeatAvailabilityService(seatLockProvider);
        final ShowService showService = new ShowService();
        final TheatreService theatreService = new TheatreService();

        bookingController = new BookingController(bookingService, theatreService, showService) ;
        movieController = new MovieController(movieService);
        paymentController = new PaymentController(bookingService, paymentService) ;
        theatreController = new TheatreController(theatreService);
        showController = new ShowController(showService, theatreService, seatAvailabilityService, movieService) ;
    }

    protected List<Seat> createSeats(String screenId, Integer numRows, Integer numSeats) {
        List<Seat> seats = new ArrayList<>();
        for (int row=0 ; row<numRows ; row++) {
            for (int seat=0 ; seat < numSeats ; seat++) {
                theatreController.createSeatInScreen(row, seat, screenId);
            }
        }
        return seats ;
    }

    protected String setUpScreen() {
        final String theatreId = theatreController.createTheatre("Theatre1") ;
        return theatreController.createScreenInTheatre("Screen1", theatreId) ;
    }

    public abstract void executeTests() ;
}
