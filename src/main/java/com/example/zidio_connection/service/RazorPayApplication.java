package com.example.zidio_connection.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RazorPayApplication
{
    public static void main(String[] args)
    {
        org.springframework.boot.SpringApplication.run(RazorPayApplication.class, args);
    }

}
