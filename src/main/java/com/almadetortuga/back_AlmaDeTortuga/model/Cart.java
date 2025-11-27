package com.almadetortuga.back_AlmaDeTortuga.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Long idCart; // Corregido a camelCase

    @Column(nullable = false)
    private StatusCart statusCart;

    // -- Relacion Cart to User N:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();

    public Cart() {
    }

    public Cart(Long idCart, StatusCart statusCart) {
        this.idCart = idCart;
        this.statusCart = statusCart;
    }

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public StatusCart getStatusCart() {
        return statusCart;
    }

    public void setStatusCart(StatusCart statusCart) {
        this.statusCart = statusCart;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cart cart)) return false;
        return Objects.equals(idCart, cart.idCart) && statusCart == cart.statusCart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCart, statusCart);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "idCart=" + idCart +
                ", statusCart=" + statusCart +
                '}';
    }
}