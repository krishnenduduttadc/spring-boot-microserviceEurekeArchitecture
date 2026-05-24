package com.example.user_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${message}")
    private String msg;

    @GetMapping("/users")
    public String users() {

        return msg;
    }
}
