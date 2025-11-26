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

    // Relación Cart to Product N:M
    @ManyToMany
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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