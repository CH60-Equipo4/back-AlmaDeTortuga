package com.almadetortuga.back_AlmaDeTortuga.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long deliveryID;

    @Column(name = "delivery_address", length = 255)
    private String deliveryAddress;

    @Column(name = "tracking_number", length = 50)
    private String trackingNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "estimated_delivery")
    private LocalDate estimatedDelivery;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusDelivery statusDelivery;

    @OneToMany(
            mappedBy = "delivery", // Indica el campo en la clase Cart que posee la FK.
            cascade = CascadeType.ALL, // Las operaciones (guardar, eliminar) en User se propagan a Cart.
            orphanRemoval = true // Si eliminas un Cart de la lista, se borra de la DB.
    )
    private List<Order> orders = new ArrayList<>();

    public Delivery(Long deliveryID, String deliveryAddress, String trackingNumber, LocalDateTime deliveryDate, LocalDate estimatedDelivery, StatusDelivery statusDelivery) {
        this.deliveryID = deliveryID;
        this.deliveryAddress = deliveryAddress;
        this.trackingNumber = trackingNumber;
        this.deliveryDate = deliveryDate;
        this.estimatedDelivery = estimatedDelivery;
        this.statusDelivery = statusDelivery;
    }

    public Delivery(){

    }

    public Long getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(Long deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public void setEstimatedDelivery(LocalDate estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }

    public StatusDelivery getStatusDelivery() {
        return statusDelivery;
    }

    public void setStatusDelivery(StatusDelivery statusDelivery) {
        this.statusDelivery = statusDelivery;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryID=" + deliveryID +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", deliveryDate=" + deliveryDate +
                ", estimatedDelivery=" + estimatedDelivery +
                ", statusDelivery=" + statusDelivery +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Delivery delivery)) return false;
        return Objects.equals(deliveryID, delivery.deliveryID) && Objects.equals(deliveryAddress, delivery.deliveryAddress) && Objects.equals(trackingNumber, delivery.trackingNumber) && Objects.equals(deliveryDate, delivery.deliveryDate) && Objects.equals(estimatedDelivery, delivery.estimatedDelivery) && statusDelivery == delivery.statusDelivery;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryID, deliveryAddress, trackingNumber, deliveryDate, estimatedDelivery, statusDelivery);
    }
}
