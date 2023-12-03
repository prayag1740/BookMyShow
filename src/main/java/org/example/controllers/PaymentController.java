package org.example.controllers;

import org.example.models.User;
import org.example.services.BookingService;
import org.example.services.PaymentService;


public class PaymentController {

    private final BookingService bookingService;
    private final PaymentService paymentService;

    public PaymentController(BookingService bookingService, PaymentService paymentService) {
        this.bookingService = bookingService;
        this.paymentService = paymentService;
    }

    public void paymentSuccess(String bookingId, User user) {
        this.bookingService.confirmBooking(this.bookingService.getBooking(bookingId), user);
    }

    public void paymentFail(String bookingId, User user) {
        this.paymentService.processPaymentFail(this.bookingService.getBooking(bookingId), user);
    }

}
