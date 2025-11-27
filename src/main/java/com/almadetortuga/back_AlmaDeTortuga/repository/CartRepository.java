package com.almadetortuga.back_AlmaDeTortuga.repository;

import com.almadetortuga.back_AlmaDeTortuga.model.Cart;
import com.almadetortuga.back_AlmaDeTortuga.model.StatusCart; // Asegúrate de importar tu Enum
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    // Buscar carritos por el id del usuario (Propiedad 'user' -> propiedad 'idUser')
    List<Cart> findByUserIdUser(Long idUser);

    // Buscar carritos por el id del producto
    List<Cart> findByItemsProductIdProduct(Long idProduct);

    // Buscar carritos por estado (Usa el tipo concreto StatusCart)
    List<Cart> findByStatusCart(StatusCart statusCart);
}