package com.almadetortuga.back_AlmaDeTortuga.repository;
import com.almadetortuga.back_AlmaDeTortuga.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>  {

}
