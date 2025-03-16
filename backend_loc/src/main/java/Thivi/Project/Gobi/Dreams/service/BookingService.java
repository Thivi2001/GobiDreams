package Thivi.Project.Gobi.Dreams.service;

import Thivi.Project.Gobi.Dreams.dto.BookingDTO;
import Thivi.Project.Gobi.Dreams.entity.Booking;
import Thivi.Project.Gobi.Dreams.entity.BookingStatus;
import Thivi.Project.Gobi.Dreams.entity.Customer;
import Thivi.Project.Gobi.Dreams.entity.Photographer;
import Thivi.Project.Gobi.Dreams.mapper.EntityMapper;
import Thivi.Project.Gobi.Dreams.repository.BookingRepository;
import Thivi.Project.Gobi.Dreams.repository.CustomerRepository;
import Thivi.Project.Gobi.Dreams.repository.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PhotographerRepository photographerRepository;

    @Autowired
    private EntityMapper entityMapper;

    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Customer customer = customerRepository.findById(bookingDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Photographer photographer = photographerRepository.findById(bookingDTO.getPhotographerId())
                .orElseThrow(() -> new RuntimeException("Photographer not found"));

        Booking booking = new Booking(null, customer, photographer, bookingDTO.getSessionDate(),
                bookingDTO.getEventType(), BookingStatus.PENDING);

        bookingRepository.save(booking);
        return entityMapper.bookingToBookingDTO(booking);
    }

    public BookingDTO getBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        return entityMapper.bookingToBookingDTO(booking);
    }

    public BookingDTO updateBooking(Long id, BookingDTO bookingDTO) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        booking.setSessionDate(bookingDTO.getSessionDate());
        booking.setEventType(bookingDTO.getEventType());
        booking.setStatus(bookingDTO.getStatus());
        bookingRepository.save(booking);

        return entityMapper.bookingToBookingDTO(booking);
    }

    public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }
}
