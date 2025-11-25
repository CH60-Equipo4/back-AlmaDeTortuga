package com.almadetortuga.back_AlmaDeTortuga.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("No se encuentra el Order con el id: " + id);
    }
}
