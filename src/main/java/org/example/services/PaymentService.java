package org.example.services;

import org.example.exceptions.BadRequestException;
import org.example.models.Booking;
import org.example.models.User;
import org.example.providers.SeatLockProvider;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {

    private final Map<String, Integer> bookingFails ;
    private static Integer MAX_RETRIES = 3 ;
    private final SeatLockProvider seatLockProvider ;

    public PaymentService(SeatLockProvider seatLockProvider) {
        this.bookingFails = new HashMap<>();
        this.seatLockProvider = seatLockProvider;
    }

    public void processPaymentFail(Booking booking, User user) {
        if (!booking.getUser().equals(user)) {
            throw new BadRequestException();
        }
        String bookingId = booking.getId();
        if (!this.bookingFails.containsKey(bookingId)) {
            this.bookingFails.put(bookingId, 0);
        }
        final Integer currentFailCount = this.bookingFails.get(bookingId);
        final Integer newFailCount = currentFailCount + 1 ;
        this.bookingFails.put(bookingId, newFailCount);
        if (newFailCount > MAX_RETRIES) {
            seatLockProvider.unlockSeats(booking.getShow(), booking.getSeatsBooked(), user);
        }
    }
}
