package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.exceptions.UserNotFoundException;
import com.almadetortuga.back_AlmaDeTortuga.model.User;
import com.almadetortuga.back_AlmaDeTortuga.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    // getById / get / path="/id-user/{id}"
    @GetMapping("/id-user/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        try {
            User userById = userService.findById(id);
            // return ResponseEntity.status(HttpStatus.OK).body(userById);
            return ResponseEntity.ok(userById);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // deleteById / delete / path="/delete-user/{id}" / 204 y 404
    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // updateById / put / path="/update-user/{id}" / 201 y 404
    @PutMapping("/update-user/{id}")
    public ResponseEntity<User> updateById(@RequestBody User user, @PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(userService.updateUser(user, id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
