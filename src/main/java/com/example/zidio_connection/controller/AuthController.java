package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.AuthResponse;
import com.example.zidio_connection.DTO.LoginRequest;
import com.example.zidio_connection.DTO.RegisterRequest;
import com.example.zidio_connection.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse>register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse>login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

}
