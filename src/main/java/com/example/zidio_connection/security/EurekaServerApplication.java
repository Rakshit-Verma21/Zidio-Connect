package com.example.zidio_connection.security;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication
{
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(EurekaServerApplication.class, args);
    }

}
