package org.example.scenarios;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.example.models.Seat;
import org.example.models.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CaseTest1 extends BaseTest {

    public void executeTests() {

        super.setupControllers(1000);

        User user1 = new User(1, "prayag", "prayag740@gmail.com") ;
        User user2 = new User(2, "pinku", "pinku@gmail.com") ;

        final String movie = movieController.createMovie("Movie1") ;
        final String screenId = super.setUpScreen();
        List<Seat> allSeats = super.createSeats(screenId, 2, 10) ;
        final String show = showController.createShow(movie, screenId , LocalDateTime.now(), 7200) ;
        List<String> user1availableSeats = showController.getAvailableSeats(show) ;
        System.out.println(user1availableSeats.size());

        List<String> u1SelectedSeats = new ArrayList<>();
        u1SelectedSeats.add(user1availableSeats.get(0)) ;
        u1SelectedSeats.add(user1availableSeats.get(5)) ;
        u1SelectedSeats.add(user1availableSeats.get(17)) ;

        final String u1Bookingid = bookingController.createBooking(user1, show, u1SelectedSeats) ;
        paymentController.paymentSuccess(u1Bookingid, user1);

        final List<String> u2availableSeats = showController.getAvailableSeats(show) ;
        System.out.println(u2availableSeats.size());

    }

}
