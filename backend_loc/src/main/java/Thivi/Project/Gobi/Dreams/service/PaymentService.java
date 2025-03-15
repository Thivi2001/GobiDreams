package Thivi.Project.Gobi.Dreams.service;

import Thivi.Project.Gobi.Dreams.entity.Payment;
import Thivi.Project.Gobi.Dreams.entity.PaymentStatus;
import Thivi.Project.Gobi.Dreams.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment processPayment(Payment payment) {
        payment.setStatus(PaymentStatus.SUCCESS); // Assuming payment is successful
        return paymentRepository.save(payment);
    }

    public List<Payment> getPaymentsByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepository.findById(id);
    }
}
