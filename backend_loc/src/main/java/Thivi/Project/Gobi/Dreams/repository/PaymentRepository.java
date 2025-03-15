package Thivi.Project.Gobi.Dreams.repository;

import Thivi.Project.Gobi.Dreams.entity.Payment;
import Thivi.Project.Gobi.Dreams.entity.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStatus(PaymentStatus status); // Get payments by status
}
