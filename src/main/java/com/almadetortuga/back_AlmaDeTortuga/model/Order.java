package com.almadetortuga.back_AlmaDeTortuga.model;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Long id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // -- Relacion Order to Delivery N:1
    @ManyToOne(fetch = FetchType.LAZY) // Carga perezosa: no carga el Delivery hasta que se necesita.
    @JoinColumn(
            name = "delivery_id", // Nombre de la columna de la clave foránea en la tabla 'order'.
            nullable = false // Una orden siempre debe estar asociada a un envio.
    )
    private Delivery delivery;

    // -- Relacion Order to Payment N:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "payment_id",
            nullable = false
    )
    private Payment payment;

    // -- Relacion Order to User N:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_user",
            nullable = false
    )
    private User user;


    // CONSTRUCTOR PARA SPRING
    public Order (){

    }

    // CONSTRUCTOR PARA OBJETOS
    public Order(Long id, LocalDate date, BigDecimal total, OrderStatus status) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.status = status;
    }

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id) && Objects.equals(date, order.date) && Objects.equals(total, order.total) && status == order.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, total, status);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                ", status=" + status +
                '}';
    }

}
