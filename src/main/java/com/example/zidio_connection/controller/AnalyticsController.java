package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.AnalyticResponse;
import com.example.zidio_connection.repository.RecruiterRepository;
import com.example.zidio_connection.repository.StudentRepository;
import com.example.zidio_connection.service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController
{
    @Autowired
    private AnalyticService analyticService;

    @GetMapping("/summary")
    public ResponseEntity<AnalyticResponse> getAnalyticsSummary() {
        AnalyticResponse response = analyticService.collectData();
        return ResponseEntity.ok(response);
    }







}
