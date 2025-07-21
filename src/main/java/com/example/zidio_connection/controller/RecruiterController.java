package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.RecruiterDTO;
import com.example.zidio_connection.repository.RecruiterRepository;
import com.example.zidio_connection.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController
{
    @Autowired
    private RecruiterService recruiterService;
    @Autowired
    private RecruiterRepository recruiterRepository;


    @PostMapping("/register")
    public ResponseEntity <RecruiterDTO> register(@RequestBody RecruiterDTO dto)
    {
        return ResponseEntity.ok(recruiterService.createRecruiter(dto));
    }

    @GetMapping("/{email}")
    public ResponseEntity<RecruiterDTO>getByEmail(@PathVariable String email)
    {
        return ResponseEntity.ok(recruiterService.getRecruiterByEmail(email));
    }

    @GetMapping("/{id}")
    public ResponseEntity <RecruiterDTO> getById(@PathVariable Long id)
    {
        return ResponseEntity.ok(recruiterService.getRecruiterById(id));
    }

    @GetMapping("/internal/count")
    public ResponseEntity<Long> getRecruiterCount()
    {
        return ResponseEntity.ok(recruiterRepository.count());
    }



}
