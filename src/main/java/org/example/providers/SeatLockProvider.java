package org.example.providers;

import org.example.models.Seat;
import org.example.models.Show;
import org.example.models.User;

import java.util.List;

public interface SeatLockProvider {

    void lockSeats(Show show, List<Seat> seats, User user) ;
    void unlockSeats(Show show, List<Seat> seats, User user);

    boolean validateLock(Show show, Seat seat, User user);
    List<Seat> getLockedSeats(Show show) ;


}
