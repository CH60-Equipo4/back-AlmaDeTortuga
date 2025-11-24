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
    private Long id_cart;

    @Column(nullable = false)
    private StatusCart statusCart;

    // -- Relacion Cart to User N:1
    @ManyToOne(fetch = FetchType.LAZY) // Carga perezosa: no carga el User hasta que se necesita.
    @JoinColumn(
            name = "user_id", // Nombre de la columna de la clave foránea en la tabla 'cart'.
            nullable = false // Un carrito siempre debe estar asociado a un usuario.
    )


    private User user;

    // -- Relación Cart to Product N:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_producto",  // nombre de la FK en la tabla cart
            nullable = false
    )
    private Product product;

    public Cart() {
    }

    public Cart(Long id_cart, StatusCart statusCart) {
        this.id_cart = id_cart;
        this.statusCart = statusCart;
    }

    public Long getId_cart() {
        return id_cart;
    }

    public void setId_cart(Long id_cart) {
        this.id_cart = id_cart;
    }

    public StatusCart getStatusCart() {
        return statusCart;
    }

    public void setStatusCart(StatusCart statusCart) {
        this.statusCart = statusCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cart cart)) return false;
        return Objects.equals(id_cart, cart.id_cart) && statusCart == cart.statusCart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_cart, statusCart);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id_cart=" + id_cart +
                ", statusCart=" + statusCart +
                '}';
    }
}
