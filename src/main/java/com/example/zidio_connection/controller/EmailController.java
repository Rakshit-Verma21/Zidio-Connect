package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.EmailNotificationRequest;
import com.example.zidio_connection.service.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notify")
public class EmailController
{
    @Autowired
    private EmailNotificationService service;

    @PostMapping("/send")
    public ResponseEntity sendEmail(@RequestBody EmailNotificationRequest request)
    {
        service.sendEmail(request);
        return ResponseEntity.ok("Email sent Successsfully");

    }

}
