
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
    @Column(name = "id_producto")
    private Long id_producto;

    @Column(name = "nombre_producto", nullable = false, length = 150)
    private String nombreProducto;

    // text(1000) en DB se suele mapear con length grande o columnDefinition="TEXT"
    @Column(name = "descripcion_producto", nullable = false, length = 1000)
    private String descripcionProducto;

    // DECIMAL(10,2) siempre debe ser BigDecimal en Java
    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "url_imagen_producto", nullable = false, length = 250)
    private String urlImagenProducto;

    /* -------- Relación de Product a Cart 1:N ----------

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> carts = new ArrayList<>(); */

    // -------- Relación de Product a Pedido N:M ----------

  /*  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "producto_has_pedido",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_pedido")
    )
    private Set<Pedido> pedidos = new HashSet<>(); */

    // -------- Constructores ---------- //

    public Product() {
    }

    public Product(Long id_producto, String nombreProducto, String descripcionProducto, BigDecimal precio, Integer stock, String urlImagenProducto) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precio = precio;
        this.stock = stock;
        this.urlImagenProducto = urlImagenProducto;
    }

    // -------- Getters y Setters ----------

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getUrlImagenProducto() {
        return urlImagenProducto;
    }

    public void setUrlImagenProducto(String urlImagenProducto) {
        this.urlImagenProducto = urlImagenProducto;
    }

   /* public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

   /* public Set<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    */

    // -------- Overrides (Equals, HashCode, ToString) ----------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id_producto, product.id_producto) &&
                Objects.equals(nombreProducto, product.nombreProducto) &&
                Objects.equals(descripcionProducto, product.descripcionProducto) &&
                Objects.equals(precio, product.precio) &&
                Objects.equals(stock, product.stock) &&
                Objects.equals(urlImagenProducto, product.urlImagenProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_producto, nombreProducto, descripcionProducto, precio, stock, urlImagenProducto);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_producto=" + id_producto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", urlImagenProducto='" + urlImagenProducto + '\'' +
                '}';
    }
}