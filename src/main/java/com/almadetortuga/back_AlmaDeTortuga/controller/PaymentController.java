package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.model.Payment;
import com.almadetortuga.back_AlmaDeTortuga.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> findAllPayments() {
        return paymentService.getPayments();
    }

    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(payment));
    }
}