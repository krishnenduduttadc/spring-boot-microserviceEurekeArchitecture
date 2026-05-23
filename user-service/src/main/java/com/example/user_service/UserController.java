package com.example.user_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${server.port}")
    private String p;

//    @GetMapping("/users")
//    public String users() {
//        return "User Service from " + p;
//    }

    @GetMapping("/users")
    public User users() {
        return new User(1, "Krish");
    }
}
