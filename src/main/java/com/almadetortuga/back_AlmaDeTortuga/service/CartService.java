package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.model.Cart;
import com.almadetortuga.back_AlmaDeTortuga.model.Product;
import com.almadetortuga.back_AlmaDeTortuga.repository.CartRepository;
import com.almadetortuga.back_AlmaDeTortuga.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // Crear un nuevo carrito
    public Cart createCart(Cart newCart) {
        return cartRepository.save(newCart);
    }

    // Obtener todos los carritos
    public List<Cart> getCarts() {
        return cartRepository.findAll();
    }

    // Obtener un carrito por ID
    public Cart getCartById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con id: " + id));
    }

    // Actualizar un carrito
    public Cart updateCart(Long id, Cart updatedCart) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con id: " + id));

        cart.setStatusCart(updatedCart.getStatusCart());

        return cartRepository.save(cart);
    }

    // Eliminar un carrito
    public void deleteCart(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado con id: " + id));
        cartRepository.delete(cart);
    }

    // Obtener carritos de un usuario específico
    public List<Cart> getCartsByUserId(Long userId) {
        // Corregido al nuevo nombre del método en el repositorio
        return cartRepository.findByUserIdUser(userId);
    }

    // Agregar producto al carrito
    public Cart addProductToCart(Long cartId, Long productId) {
        Cart cart = getCartById(cartId);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + productId));

        cart.getProducts().add(product);
        return cartRepository.save(cart);
    }

    // Quitar producto del carrito
    public Cart removeProductFromCart(Long cartId, Long productId) {
        Cart cart = getCartById(cartId);
        // Se asume que en la clase Product también corregirás getId_product() a getIdProduct()
        cart.getProducts().removeIf(p -> p.getIdProduct().equals(productId));
        return cartRepository.save(cart);
    }
}