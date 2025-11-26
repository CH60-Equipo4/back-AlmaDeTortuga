package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.model.Payment;
import com.almadetortuga.back_AlmaDeTortuga.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Lista todos los pagos
    public List<Payment> getPayments() {
        return paymentRepository.findAll();
    }

    // Crea un nuevo pago
    public Payment createPayment(Payment newPayment) {
        return paymentRepository.save(newPayment);
    }
}