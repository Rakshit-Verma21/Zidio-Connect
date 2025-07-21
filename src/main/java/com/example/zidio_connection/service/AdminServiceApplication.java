package com.example.zidio_connection.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminServiceApplication
{
    public static void main(String[] args)
    {
        org.springframework.boot.SpringApplication.run(AdminServiceApplication.class, args);
    }
}
