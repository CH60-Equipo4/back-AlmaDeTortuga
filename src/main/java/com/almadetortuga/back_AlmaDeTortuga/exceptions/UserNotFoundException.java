package com.almadetortuga.back_AlmaDeTortuga.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("No se encuentra el User con id " + id);
    }
}
