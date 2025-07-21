package com.example.zidio_connection.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BillingServiceApplication
{
    public static void main(String[] args)
    {
        org.springframework.boot.SpringApplication.run(BillingServiceApplication.class, args);
    }
}
