package com.almadetortuga.back_AlmaDeTortuga.controller;

import com.almadetortuga.back_AlmaDeTortuga.model.User;
import com.almadetortuga.back_AlmaDeTortuga.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
