package com.ariya.controller;

import com.ariya.dto.LoginRequest;
import com.ariya.dto.RegisterRequest;
import com.ariya.entity.User;
import com.ariya.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;



@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/auth/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {

        boolean authenticated = userService.login(request.getUsername(), request.getPassword());

        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        }

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body("Invalid username or password");
    }


    @PostMapping("/api/auth/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        try {
            User user = userService.register(
                    request.getUsername(),
                    request.getPassword()
            );

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Registered user: " + user.getUsername());

        } catch (IllegalArgumentException exception) {

            if ("Username already exists".equals(exception.getMessage())) {
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(exception.getMessage());
            }

            return ResponseEntity
                    .badRequest()
                    .body(exception.getMessage());
        }
    }
}