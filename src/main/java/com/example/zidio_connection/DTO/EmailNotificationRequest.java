package com.example.zidio_connection.DTO;

public class EmailNotificationRequest
{
    public String to;
    public String subject;
    public String body;

    public EmailNotificationRequest() {
    }
    public EmailNotificationRequest(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
