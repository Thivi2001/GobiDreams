package Thivi.Project.Gobi.Dreams.repository;

import Thivi.Project.Gobi.Dreams.entity.Booking;
import Thivi.Project.Gobi.Dreams.entity.BookingStatus;
import Thivi.Project.Gobi.Dreams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCustomer(User customer); // Get all bookings by a customer
    List<Booking> findByStatus(BookingStatus status); // Get bookings by status
}
