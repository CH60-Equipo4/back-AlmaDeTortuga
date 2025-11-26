package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.model.Cart;
import com.almadetortuga.back_AlmaDeTortuga.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Obtener todos los carritos
    @GetMapping
    public ResponseEntity<List<Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getCarts());
    }

    // Obtener carrito por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.getCartById(id));
    }

    // Crear carrito
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    // Actualizar carrito
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart cart) {
        return ResponseEntity.ok(cartService.updateCart(id, cart));
    }

    // Eliminar carrito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }

    // Agregar producto al carrito
    @PostMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return ResponseEntity.ok(cartService.addProductToCart(cartId, productId));
    }

    // Quitar producto del carrito
    @DeleteMapping("/{cartId}/products/{productId}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return ResponseEntity.ok(cartService.removeProductFromCart(cartId, productId));
    }
}
