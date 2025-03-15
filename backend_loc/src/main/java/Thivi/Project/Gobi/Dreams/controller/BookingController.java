package Thivi.Project.Gobi.Dreams.controller;

import Thivi.Project.Gobi.Dreams.entity.Booking;
import Thivi.Project.Gobi.Dreams.entity.User;
import Thivi.Project.Gobi.Dreams.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.createBooking(booking));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.getBookingById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Booking>> getBookingsByCustomer(@RequestBody User customer) {
        return ResponseEntity.ok(bookingService.getBookingsByCustomer(customer));
    }
}
