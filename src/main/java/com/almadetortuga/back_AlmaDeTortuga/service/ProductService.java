package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.model.Product;
import com.almadetortuga.back_AlmaDeTortuga.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Lista de todos los productos
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    // Crear un nuevo producto
    public Product createProduct(Product newProduct){
        return productRepository.save(newProduct);
    }
    // Obtener un producto por ID
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
    }

    // Actualizar un producto existente
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));

        // Actualizar los campos
        product.setNombreProducto(updatedProduct.getNombreProducto());
        product.setDescripcionProducto(updatedProduct.getDescripcionProducto());
        product.setPrecio(updatedProduct.getPrecio());
        product.setStock(updatedProduct.getStock());
        product.setUrlImagenProducto(updatedProduct.getUrlImagenProducto());

        return productRepository.save(product);
    }

    // Eliminar un producto
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        productRepository.delete(product);
    }



}