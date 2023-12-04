package org.example.scenarios;

import org.example.models.Seat;
import org.example.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CaseTest2 extends BaseTest {

    @Override
    public void executeTests() {
        super.setupControllers(1000);

        User user1 = new User(1, "prayag", "prayag740@gmail.com") ;
        User user2 = new User(2, "pinku", "pinku@gmail.com") ;

        final String movie = movieController.createMovie("Movie1") ;
        final String screenId = super.setUpScreen();
        System.out.println("Screen id is " + screenId) ;
        List<Seat> allSeats = super.createSeats(screenId, 2, 10) ;
        final String show = showController.createShow(movie, screenId , LocalDateTime.now(), 7200) ;
        List<String> user1availableSeats = showController.getAvailableSeats(show) ;

        List<String> u1SelectedSeats = new ArrayList<>();
        u1SelectedSeats.add(user1availableSeats.get(0)) ;
        u1SelectedSeats.add(user1availableSeats.get(5)) ;
        u1SelectedSeats.add(user1availableSeats.get(17)) ;

        List<String> u1SelectedSeatsImmutable = Collections.unmodifiableList(u1SelectedSeats);

        final String u1BookingId = bookingController.createBooking(user1, show, u1SelectedSeatsImmutable) ;

        final List<String> u2availableSeats = showController.getAvailableSeats(show) ;
        System.out.println("U2 seats after u1 booking creation -- " + u2availableSeats.size());

        paymentController.paymentFail(u1BookingId, user1);

        final List<String> u2availableSeatsTry3 = showController.getAvailableSeats(show) ;
        System.out.println("u2 seats after u1 payment fail -- " + u2availableSeatsTry3.size());

    }
}
