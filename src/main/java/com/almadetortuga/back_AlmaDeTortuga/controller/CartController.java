package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.dto.CartItemRequestDTO;
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

    //Agregar un nuevo producto al carrito
    @PostMapping("/{cartId}/items")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long cartId, @RequestBody CartItemRequestDTO itemDto) {
        Cart updatedCart = cartService.addItemToCart(cartId, itemDto);
        // Devuelve el carrito completo actualizado para que el frontend lo use
        return ResponseEntity.ok(updatedCart);
    }

    // eliminar un carrito
    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<Void> removeItemFromCart(@PathVariable Long cartItemId) {
        cartService.removeItemFromCart(cartItemId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/items/{cartItemId}/decrement")
    public ResponseEntity<Cart> decrementItemQuantity(@PathVariable Long cartItemId,
                                                      @RequestParam(defaultValue = "1") int quantity) {
        // Usamos PUT para reflejar que estamos modificando el estado del CartItem.
        Cart updatedCart = cartService.decrementItemQuantity(cartItemId, quantity);
        return ResponseEntity.ok(updatedCart);
    }
}
