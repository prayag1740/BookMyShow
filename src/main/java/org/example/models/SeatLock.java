package org.example.models;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class SeatLock {

    private final Seat seat;
    private final Show show;
    private final Integer timeoutSeconds ;
    private final Date date ;
    private final User user ;

    public SeatLock(Seat seat, Show show, Integer timeoutSeconds, Date date, User user) {
        this.seat = seat ;
        this.show = show ;
        this.timeoutSeconds = timeoutSeconds ;
        this.date = date ;
        this.user = user ;
    }

    public boolean isLockExpired() {
        ZoneId zoneId = ZoneId.of("UTC") ;
        final Instant lockInstant = this.date.toInstant().plusSeconds(this.timeoutSeconds) ;
        final Instant currentInstant = new Date().toInstant() ;
       return lockInstant.isBefore(currentInstant) ;
    }

    public User getLockedByUser() {
        return this.user ;
    }

}
