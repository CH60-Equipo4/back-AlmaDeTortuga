package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.dto.CartItemRequestDTO;
import com.almadetortuga.back_AlmaDeTortuga.model.Cart;
import com.almadetortuga.back_AlmaDeTortuga.model.CartItem;
import com.almadetortuga.back_AlmaDeTortuga.model.Product;
import com.almadetortuga.back_AlmaDeTortuga.repository.CartItemRepository;
import com.almadetortuga.back_AlmaDeTortuga.repository.CartRepository;
import com.almadetortuga.back_AlmaDeTortuga.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
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

    public Cart addItemToCart(Long cartId, CartItemRequestDTO itemDto) {
        Cart cart = getCartById(cartId);
        Product product = productRepository.findById(itemDto.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + itemDto.getProductId()));

        // 1. Intentar encontrar un CartItem existente con la misma personalización
        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item ->
                        item.getProduct().getIdProduct().equals(product.getIdProduct()) &&
                                // Compara los detalles de personalización como string
                                Objects.equals(item.getCustomDetailsJson(), itemDto.getCustomDetailsJson())
                )
                .findFirst();

        if (existingItem.isPresent()) {
            // Si el ítem ya existe, solo incrementa la cantidad
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + itemDto.getQuantity());
            // Guardar el CartItem actualizado
            cartItemRepository.save(item);
        } else {
            // 2. Si es un ítem nuevo (o con personalización diferente), crea un CartItem
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(itemDto.getQuantity());
            newItem.setFinalUnitPrice(itemDto.getFinalUnitPrice());
            newItem.setCustomDetailsJson(itemDto.getCustomDetailsJson());

            // Asegurarse de añadir el nuevo ítem a la lista del carrito
            cart.getItems().add(newItem);
        }

        // Guardar el carrito, lo que persistirá el nuevo CartItem gracias al CascadeType.ALL
        return cartRepository.save(cart);
    }

    //Elimina un CartItem por ID
    public void removeItemFromCart(Long cartItemId) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Ítem de carrito no encontrado con id: " + cartItemId));

        // 1. Quitar el ítem de la lista del carrito padre para mantener la consistencia
        Cart cart = item.getCart();
        cart.getItems().remove(item);

        // 2. Eliminar el CartItem
        cartItemRepository.delete(item);

    }

    public Cart decrementItemQuantity(Long cartItemId, int decrementBy) {
        CartItem item = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Ítem de carrito no encontrado con id: " + cartItemId));

        int newQuantity = item.getQuantity() - decrementBy;

        if (newQuantity <= 0) {
            // Si la cantidad es 0 o menos, lo eliminamos
            removeItemFromCart(cartItemId);
            return item.getCart();
        } else {
            // Si la cantidad sigue siendo positiva, actualizamos
            item.setQuantity(newQuantity);
            cartItemRepository.save(item);
            return item.getCart();
        }
    }

    // Obtener carritos de un usuario específico
    public List<Cart> getCartsByUserId(Long userId) {
        // Corregido al nuevo nombre del método en el repositorio
        return cartRepository.findByUserIdUser(userId);
    }
}