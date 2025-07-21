package com.example.zidio_connection.service;
import com.example.zidio_connection.entity.User;
import com.example.zidio_connection.DTO.AuthResponse;
import com.example.zidio_connection.DTO.LoginRequest;
import com.example.zidio_connection.DTO.RegisterRequest;
import com.example.zidio_connection.repository.UserRepository;

import com.example.zidio_connection.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTUtil JWTUtil;


    public AuthResponse register(RegisterRequest request) {
        User user=new User();
        user.setName(request.name);
        user.setEmail(request.email);
        user.setPassword(request.password);
        user.setRole(request.role);
        userRepository.save(user);

        String token = JWTUtil.generateToken( user.getEmail(),user.getRole());
        return  new AuthResponse(token, "Registration Successful");

    }


    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.email).orElseThrow(() -> new RuntimeException("User not found"));


        if(!passwordEncoder.matches(request.password, user.getPassword()))
            throw new RuntimeException("Invalid credentials");

        String token = JWTUtil.generateToken(user.getEmail(), user.getRole());
        return new AuthResponse(token,"Login Successful");


    }
}



