package org.example.providers;

import org.example.exceptions.SeatLockException;
import org.example.models.Seat;
import org.example.models.SeatLock;
import org.example.models.Show;
import org.example.models.User;

import java.util.*;

public class InMemorySeatLockProvider implements SeatLockProvider {
    private final Integer lockTimeOut ;
    private final Map<Show, Map<Seat, SeatLock>> locks ;
    public InMemorySeatLockProvider(Integer lockTimeOut) {
        this.lockTimeOut = lockTimeOut;
        this.locks = new HashMap<>() ;
    }
    @Override
    synchronized public void lockSeats(Show show, List<Seat> seats, User user) {
        for (Seat s : seats) {
            if (isSeatLocked(show, s)) {
                throw new SeatLockException();
            }
        }
        for (Seat seat : seats) {
            lockSeat(show, seat, user);
        }
    }
    @Override
    public void unlockSeats(Show show, List<Seat> seats, User user) {
        for (Seat seat : seats) {
            unlockSeat(show, seat);
        }
    }

    @Override
    public boolean validateLock(Show show, Seat seat, User user) {
        return isSeatLocked(show, seat) && this.locks.get(show).get(seat).getLockedByUser().equals(user) ;
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {
        if (!this.locks.containsKey(show)) {
            return new ArrayList<>() ;
        }

        Map<Seat, SeatLock> seatData = this.locks.get(show) ;
        return new ArrayList<>(seatData.keySet());
    }
    private void lockSeat(Show show, Seat seat, User user) {
        if (!this.locks.containsKey(show)) {
            this.locks.put(show, new HashMap<>());
        }
        final SeatLock seatLock = new SeatLock(seat, show, this.lockTimeOut, new Date(), user) ;
        this.locks.get(show).put(seat, seatLock) ;
    }
    private void unlockSeat(Show show, Seat seat) {
        if (!this.locks.containsKey(show)) {
            return ;
        }
        this.locks.get(show).remove(seat) ;
    }
    private boolean isSeatLocked(Show show, Seat seat) {
        return this.locks.containsKey(show) && this.locks.get(show).containsKey(seat) && !this.locks.get(show).get(seat).isLockExpired();
    }
}
