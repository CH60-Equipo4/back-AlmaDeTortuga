package com.almadetortuga.back_AlmaDeTortuga.service;

import com.almadetortuga.back_AlmaDeTortuga.exceptions.DeliveryNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.Delivery;
import com.almadetortuga.back_AlmaDeTortuga.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    // Recuperar delivery
    public List<Delivery> getAllDelivery() {
        return deliveryRepository.findAll();
    }

    // crear un nuevo delivery
    public Delivery createDelivery(Delivery newDelivery){

        LocalDate startDate = newDelivery.getDeliveryDate() != null
                ? newDelivery.getDeliveryDate().toLocalDate()
                : LocalDate.now();

        LocalDate estimatedDate = startDate.plusDays(7);

        newDelivery.setEstimatedDelivery(estimatedDate);
        return deliveryRepository.save(newDelivery);
    }

    // buscar por Id
    public Delivery findById(Long id){
        return deliveryRepository.findById(id)
                .orElseThrow(() -> new DeliveryNotFoundException(id));
    }
    // Buscar por Tracking Number
    public Delivery findByTrackingNumber(String tracking_number){
        return deliveryRepository.findByTrackingNumber(tracking_number);

    }

    //Eliminar deliveries por Id
    public void deleteDelivery(Long id){
        if(deliveryRepository.existsById(id)){
            deliveryRepository.deleteById(id);
        }
        else{
            throw new DeliveryNotFoundException(id);
        }
    }

    // actualizar un delivery by id
    public Delivery updateDelivery(Delivery delivery, Long id){
        return deliveryRepository.findById(id)
                .map(deliveryMap -> {
                    deliveryMap.setDeliveryAddress(delivery.getDeliveryAddress());
                    deliveryMap.setStatusDelivery(delivery.getStatusDelivery());

                    if (delivery.getDeliveryDate() != null) {
                        deliveryMap.setDeliveryDate(delivery.getDeliveryDate());
                    }
                    if (delivery.getTrackingNumber() != null) {
                        deliveryMap.setTrackingNumber(delivery.getTrackingNumber());
                    }
                    return deliveryRepository.save(deliveryMap);
                })
                .orElseThrow(() -> new DeliveryNotFoundException(id));
    }
}
