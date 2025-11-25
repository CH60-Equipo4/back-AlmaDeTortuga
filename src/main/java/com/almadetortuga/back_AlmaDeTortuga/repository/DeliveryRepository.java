package com.almadetortuga.back_AlmaDeTortuga.repository;

import com.almadetortuga.back_AlmaDeTortuga.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findByTrackingNumber(String tracking_number);

}
