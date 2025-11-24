package com.almadetortuga.back_AlmaDeTortuga.repository;

import com.almadetortuga.back_AlmaDeTortuga.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}