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
    @Column(name = "id_producto") // Se mantiene el nombre de la columna en la DB
    private Long idProduct;       // CORREGIDO: id_product -> idProduct (CamelCase)

    @Column(name = "nombre_producto")
    private String name;

    @Column(name = "descripcion_producto")
    private String description;

    @Column(name = "precio")
    private BigDecimal price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "url_imagen_producto")
    private String urlProductImage;

    // -------- Relación de Product a Cart N:M ----------

    @ManyToMany(mappedBy = "products")
    private List<Cart> carts = new ArrayList<>(); // Es buena práctica inicializar la lista

    // -------- Relación de Product a Pedido (Order) N:M ----------

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

    // Constructor actualizado con camelCase
    public Product(Long idProduct, String name, String description, BigDecimal price, Integer stock, String urlProductImage, List<Cart> carts, Set<Order> orders) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.urlProductImage = urlProductImage;
        this.carts = carts;
        this.orders = orders;
    }

    // -------- Getters y Setters ----------

    public Long getIdProduct() {
        return idProduct;
    }

    // Setter corregido: setId_product -> setIdProduct
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
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
        // Se usan las nuevas variables en camelCase
        return Objects.equals(idProduct, product.idProduct) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(price, product.price) &&
                Objects.equals(stock, product.stock) &&
                Objects.equals(urlProductImage, product.urlProductImage) &&
                Objects.equals(carts, product.carts) &&
                Objects.equals(orders, product.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, description, price, stock, urlProductImage, carts, orders);
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
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