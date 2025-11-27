package com.almadetortuga.back_AlmaDeTortuga.repository;

import com.almadetortuga.back_AlmaDeTortuga.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartIdCartAndProductIdProduct(Long cartId, Long productId);
}
