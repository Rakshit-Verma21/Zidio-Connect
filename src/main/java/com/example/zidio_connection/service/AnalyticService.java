package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.AnalyticResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AnalyticService
{
    @Autowired
    private RestTemplate restTemplate;

    public AnalyticResponse collectData()
    {
        Long students = restTemplate.getForObject("http://student-servicec/internal/count",Long .class);
        Long recruiters = restTemplate.getForObject("http://recruiters-service/internal/count", Long.class);
        Long jobPost = restTemplate.getForObject("http://job-service/internal/count", Long.class);
        Long applications = restTemplate.getForObject("http://application-service/internal/count", Long.class);
        Long admins=restTemplate.getForObject("http://admin-service/internal/count", Long.class);
        String email=restTemplate.getForObject("http://email-service/internal/count", String.class);
        String fileUpload=restTemplate.getForObject("http://admin-service/internal/count", String.class);

        return new AnalyticResponse(students, recruiters, jobPost, applications, admins, fileUpload, email);
    }


}
