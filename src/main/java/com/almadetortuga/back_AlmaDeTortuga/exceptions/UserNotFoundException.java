package com.almadetortuga.back_AlmaDeTortuga.exceptions;

import com.almadetortuga.back_AlmaDeTortuga.model.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("No se encontro el usuario con id "+id);

    }
}
