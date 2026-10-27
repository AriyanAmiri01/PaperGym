package com.ariya.controller;

import com.ariya.dto.LoginRequest;
import com.ariya.dto.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/api/auth/login")
    public String login(@RequestBody LoginRequest request) {
        // @ Note: in the springboot this conversion between json and dto is done
        // automatically by the Jackson
        return "Received login for: " + request.getUsername();
    }


    @PostMapping("api/auth/register")
    public String register(@RequestBody RegisterRequest request){
        return "Received registration for: " + request.getUsername();
    }
}