package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.model.User;
import com.almadetortuga.back_AlmaDeTortuga.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAllUsers(){
        return userService.getUsers();
    }

    @PostMapping("/new-user")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User userByEmail = userService.findByEmail(user.getEmail());

        if( userByEmail != null ){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
        }
    }










}
