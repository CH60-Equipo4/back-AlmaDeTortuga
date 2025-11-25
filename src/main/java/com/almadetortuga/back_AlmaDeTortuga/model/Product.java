
package com.almadetortuga.back_AlmaDeTortuga.model;

import jakarta.persistence.*;
        import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id_product;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    // text(1000) en DB se suele mapear con length grande o columnDefinition="TEXT"
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    // DECIMAL(10,2) siempre debe ser BigDecimal en Java
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "urlProductImage", nullable = false, length = 250)
    private String urlProductImage;

    // -------- Relación de Product a Cart 1:N ----------

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>();

    // -------- Relación de Product a Pedido N:M ----------

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "product_has_order",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_order")
    )
    private Set<Order> orders = new HashSet<>();

    // -------- Constructores ---------- //

    public Product() {
    }

    public Product(Long id_product, String name, String description, BigDecimal price, Integer stock, String urlProductImage, List<Cart> carts, Set<Order> orders) {
        this.id_product = id_product;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.urlProductImage = urlProductImage;
        this.carts = carts;
        this.orders = orders;
    }

    // -------- Getters y Setters ----------

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUrlProductImage() {
        return urlProductImage;
    }

    public void setUrlProductImage(String urlProductImage) {
        this.urlProductImage = urlProductImage;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


    // -------- Overrides (Equals, HashCode, ToString) ----------


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id_product, product.id_product) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(stock, product.stock) && Objects.equals(urlProductImage, product.urlProductImage) && Objects.equals(carts, product.carts) && Objects.equals(orders, product.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_product, name, description, price, stock, urlProductImage, carts, orders);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_product=" + id_product +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", urlProductImage='" + urlProductImage + '\'' +
                ", carts=" + carts +
                ", orders=" + orders +
                '}';
    }
}