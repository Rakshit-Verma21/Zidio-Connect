package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.EmailNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(EmailNotificationRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.to);
        message.setSubject(request.subject);
        message.setText(request.body);

        try {
            //mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logger instead of printing stack trace
        }
    }
}