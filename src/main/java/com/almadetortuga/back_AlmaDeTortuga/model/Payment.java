package com.almadetortuga.back_AlmaDeTortuga.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Long idPayment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MethodPayment method;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPayment status;

    // -- Relacion Payment to Order 1:N
    @OneToMany(
            mappedBy = "payment", // Indica el campo en la clase Cart que posee la FK.
            cascade = CascadeType.ALL, // Las operaciones (guardar, eliminar) en User se propagan a Cart.
            orphanRemoval = true // Si eliminas un Cart de la lista, se borra de la DB.
    )
    private List<Order> orders = new ArrayList<>();

    public Payment() {}

    // Getters and setters
    public Long getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Long idPayment) {
        this.idPayment = idPayment;
    }

    public MethodPayment getMethod() {
        return method;
    }

    public void setMethod(MethodPayment method) {
        this.method = method;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public StatusPayment getStatus() {
        return status;
    }

    public void setStatus(StatusPayment status) {
        this.status = status;
    }
}
