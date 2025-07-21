package com.example.zidio_connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ZidioConnectionApplication
{
	public static void main(String[] args) {
		SpringApplication.run(ZidioConnectionApplication.class, args);
	}
}
