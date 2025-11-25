package com.almadetortuga.back_AlmaDeTortuga.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery")
    private Long id_delivery;

    @Column(name = "delivery_address", length = 255)
    private String delivery_address;

    @Column(name = "tracking_number", length = 50)
    private String tracking_number;

    @Column(name = "delivery_date")
    private LocalDateTime delivery_date;

    @Column(name = "estimated_delivery")
    private LocalDate estimated_delivery;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDelivery status_delivery;

    @OneToMany(
            mappedBy = "delivery", // Indica el campo en la clase Cart que posee la FK.
            cascade = CascadeType.ALL, // Las operaciones (guardar, eliminar) en User se propagan a Cart.
            orphanRemoval = true // Si eliminas un Cart de la lista, se borra de la DB.
    )
    private List<Order> orders = new ArrayList<>();

    public Delivery(Long id_delivery, String delivery_address, String tracking_number, LocalDateTime delivery_date, LocalDate estimated_delivery, StatusDelivery status_delivery) {
        this.id_delivery = id_delivery;
        this.delivery_address = delivery_address;
        this.tracking_number = tracking_number;
        this.delivery_date = delivery_date;
        this.estimated_delivery = estimated_delivery;
        this.status_delivery = status_delivery;
    }

    public Delivery(){

    }

    public Long getId_delivery() {
        return id_delivery;
    }

    public void setId_delivery(Long id_delivery) {
        this.id_delivery = id_delivery;
    }

    public String getdelivery_address() {
        return delivery_address;
    }

    public void setdelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String gettracking_number() {
        return tracking_number;
    }

    public void settracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public LocalDateTime getdelivery_date() {
        return delivery_date;
    }

    public void setdelivery_date(LocalDateTime delivery_date) {
        this.delivery_date = delivery_date;
    }

    public LocalDate getestimated_delivery() {
        return estimated_delivery;
    }

    public void setestimated_delivery(LocalDate estimated_delivery) {
        this.estimated_delivery = estimated_delivery;
    }

    public StatusDelivery getstatus_delivery() {
        return status_delivery;
    }

    public void setstatus_delivery(StatusDelivery status_delivery) {
        this.status_delivery = status_delivery;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id_delivery=" + id_delivery +
                ", delivery_address='" + delivery_address + '\'' +
                ", tracking_number='" + tracking_number + '\'' +
                ", delivery_date=" + delivery_date +
                ", estimated_delivery=" + estimated_delivery +
                ", status_delivery=" + status_delivery +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Delivery delivery)) return false;
        return Objects.equals(id_delivery, delivery.id_delivery) && Objects.equals(delivery_address, delivery.delivery_address) && Objects.equals(tracking_number, delivery.tracking_number) && Objects.equals(delivery_date, delivery.delivery_date) && Objects.equals(estimated_delivery, delivery.estimated_delivery) && status_delivery == delivery.status_delivery;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_delivery, delivery_address, tracking_number, delivery_date, estimated_delivery, status_delivery);
    }
}
