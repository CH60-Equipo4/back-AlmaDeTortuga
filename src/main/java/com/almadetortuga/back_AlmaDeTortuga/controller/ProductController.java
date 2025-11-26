package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.model.CustomProduct;
import com.almadetortuga.back_AlmaDeTortuga.model.Product;
import com.almadetortuga.back_AlmaDeTortuga.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @PostMapping("/custom")
    public ResponseEntity<Product> saveCustomProduct(@RequestBody CustomProduct customProduct){

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createCustomProduct(customProduct));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }


}