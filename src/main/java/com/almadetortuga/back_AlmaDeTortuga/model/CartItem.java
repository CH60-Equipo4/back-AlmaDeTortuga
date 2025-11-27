package com.almadetortuga.back_AlmaDeTortuga.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación ManyToOne con Product (¿Qué producto base estamos comprando?)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Relación ManyToOne con Cart (¿A qué carrito pertenece?)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    // Cantidad requerida (Crucial para el frontend)
    @Column(nullable = false)
    private Integer quantity;

    // Detalles de la personalización como JSON string (color, tipografía, frase, etc.)
    @Column(name = "custom_details", columnDefinition = "TEXT")
    private String customDetailsJson;

    // Precio unitario final (incluye costo base + personalización)
    @Column(name = "final_unit_price", precision = 10, scale = 2, nullable = false)
    private BigDecimal finalUnitPrice;

    public CartItem(){

    }

    public CartItem(Long id, Product product, Cart cart, Integer quantity,
                    String customDetailsJson, BigDecimal finalUnitPrice) {
        this.id = id;
        this.product = product;
        this.cart = cart;
        this.quantity = quantity;
        this.customDetailsJson = customDetailsJson;
        this.finalUnitPrice = finalUnitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCustomDetailsJson() {
        return customDetailsJson;
    }

    public void setCustomDetailsJson(String customDetailsJson) {
        this.customDetailsJson = customDetailsJson;
    }

    public BigDecimal getFinalUnitPrice() {
        return finalUnitPrice;
    }

    public void setFinalUnitPrice(BigDecimal finalUnitPrice) {
        this.finalUnitPrice = finalUnitPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", product=" + product +
                ", cart=" + cart +
                ", quantity=" + quantity +
                ", customDetailsJson='" + customDetailsJson + '\'' +
                ", finalUnitPrice=" + finalUnitPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CartItem cartItem)) return false;
        return Objects.equals(id, cartItem.id) && Objects.equals(product, cartItem.product) && Objects.equals(cart, cartItem.cart) && Objects.equals(quantity, cartItem.quantity) && Objects.equals(customDetailsJson, cartItem.customDetailsJson) && Objects.equals(finalUnitPrice, cartItem.finalUnitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, cart, quantity, customDetailsJson, finalUnitPrice);
    }
}
