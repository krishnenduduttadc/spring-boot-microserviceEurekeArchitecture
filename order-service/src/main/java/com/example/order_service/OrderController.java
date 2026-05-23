package com.example.order_service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final UserClient uc;

    public OrderController(UserClient uc) {
        this.uc = uc;
    }

    @GetMapping("/orders")
    @CircuitBreaker(
            name = "userService",
            fallbackMethod = "fallbackResponse"
    )
    public User orders() {
        return uc.getUsers();
    }


    public User fallbackResponse(Exception e) {

        User u = new User();

        u.setId(-1);
        u.setName("User Service Down");

        return u;
    }
}
