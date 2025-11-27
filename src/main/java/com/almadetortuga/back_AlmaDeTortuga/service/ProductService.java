package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.model.Category;
import com.almadetortuga.back_AlmaDeTortuga.model.CustomProduct;
import com.almadetortuga.back_AlmaDeTortuga.model.Product;
import com.almadetortuga.back_AlmaDeTortuga.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    // Lista de todos los productos
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Crear un nuevo producto classic o collection
    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }

    // Crear un nuevo producto custom
    public CustomProduct createCustomProduct(CustomProduct newCustomProduct) {
        return productRepository.save(newCustomProduct);
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
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setStock(updatedProduct.getStock());
        product.setUrlProductImage(updatedProduct.getUrlProductImage());

        return productRepository.save(product);
    }

    // Eliminar un producto
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        productRepository.delete(product);
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public List<Product> getTopProductsByCategory(Category category, Integer count) {
        return productRepository.findByCategory(category)
                .stream()
                .limit(count)
                .collect(Collectors.toList());
    }


}