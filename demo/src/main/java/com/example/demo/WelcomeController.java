// 1. Simple REST API
// Problem:Create a basic Spring Boot application that exposes a GET API at /welcome, returning a welcome message in JSON format.
// Goal:Understand project setup, @RestController, and basic @GetMapping.



package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    public Map<String, String> welcome() {
        return Map.of("message", "Welcome to Spring Boot!");
    }
}
