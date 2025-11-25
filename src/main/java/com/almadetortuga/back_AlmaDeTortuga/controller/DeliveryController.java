package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.exceptions.DeliveryNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.Delivery;
import com.almadetortuga.back_AlmaDeTortuga.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> getDeliveries(){
        return deliveryService.getAllDelivery();
    }

    // guardar nuevo delivery
    @PostMapping("/new-delivery")
    public ResponseEntity<Delivery> saveDelivery(@RequestBody Delivery newDelivery){
        //Delivery deliveryById = deliveryService.findById(newDelivery.getDeliveryID());
        Delivery deliveryByTracking = deliveryService.findByTrackingNumber(newDelivery.getTrackingNumber());

        if(/*deliveryById != null ||*/ deliveryByTracking != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED).body(deliveryService.createDelivery(newDelivery));
        }
    }

    @GetMapping("/id-delivery/{id}")
    public ResponseEntity<Delivery> getById(@PathVariable Long id){
        try{
            Delivery deliveryId = deliveryService.findById(id);
            return ResponseEntity.ok(deliveryId);
        }
        catch (DeliveryNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        try{
            deliveryService.deleteDelivery(id);
            return  ResponseEntity.noContent().build();
        }
        catch (DeliveryNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update-user/{id}")
    public ResponseEntity<Delivery> updateById(@RequestBody Delivery delivery, @PathVariable Long id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(deliveryService.updateDelivery(delivery,id));
        }
        catch (DeliveryNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
