package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.ApplicationDTO;
import com.example.zidio_connection.Enum.Status;
import com.example.zidio_connection.repository.ApplicationRepository;
import com.example.zidio_connection.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController
{
    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping("/apply")
    public ResponseEntity<ApplicationDTO> apply(@RequestBody ApplicationDTO dto){
        return ResponseEntity.ok(applicationService.apply(dto));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<ApplicationDTO>>getApplicationByStudentId(@PathVariable Long studentId){
        return ResponseEntity.ok(applicationService.getApplicationByStudentID(studentId));
    }
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationDTO>>getApplicationByJoId(@PathVariable Long jobId){
        return ResponseEntity.ok(applicationService.getApplicationByJobID(jobId));
    }
    @PostMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id,@RequestParam Status status) {
        applicationService.updateApplicationStatus(id, status);
    }

    @GetMapping("/internal/count")
    public ResponseEntity<Long> getApplicationCount() {
        Long count = applicationRepository.count();
        return ResponseEntity.ok(count);
    }



}
