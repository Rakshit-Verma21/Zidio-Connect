package com.example.zidio_connection.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PaymentServiceApplication
{
    public static void main(String[] args) {
        // This is where the application would start, typically with Spring Boot.
        org.springframework.boot.SpringApplication.run(PaymentServiceApplication.class, args);
        // Additional initialization code would go here.
    }
}
