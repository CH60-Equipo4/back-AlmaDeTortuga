package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.model.Delivery;
import com.almadetortuga.back_AlmaDeTortuga.service.DeliveryService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> getDeliveries(){
        return deliveryService.getAllDelivery();
    }
}
