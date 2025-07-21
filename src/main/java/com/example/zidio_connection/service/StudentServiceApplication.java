package com.example.zidio_connection.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StudentServiceApplication
{
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(StudentServiceApplication.class, args);
    }
}
