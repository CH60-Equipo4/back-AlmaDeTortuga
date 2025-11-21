package com.almadetortuga.back_AlmaDeTortuga.exceptions;

public class DeliveryNotFoundException extends RuntimeException {
    public DeliveryNotFoundException(Long track_id) {
        super("No se ecuentra la orden de envio con el id de rastreo: 0" + track_id);
    }
}
