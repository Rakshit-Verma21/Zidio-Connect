package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.JobPostDTO;
import com.example.zidio_connection.Enum.JobType;
import com.example.zidio_connection.repository.JobPostRepository;
import com.example.zidio_connection.service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPosts")
public class JobPostController
{
    @Autowired
    private JobPostService jobPostService;

    @Autowired
    private JobPostRepository jobPostRepository;

    @PostMapping
    public ResponseEntity<JobPostDTO> createJob(@RequestBody JobPostDTO dto)
    {
        return ResponseEntity.ok(jobPostService.postJob(dto));
    }

    @GetMapping("/recruiter")
    public ResponseEntity<List<JobPostDTO>> getByPostedEmail(@RequestParam String email)
    {
        return ResponseEntity.ok(jobPostService.getByPostedByEmail(email));
    }

    @GetMapping("/jobTitle")
    public ResponseEntity<List<JobPostDTO>> getByJobTitle(@RequestParam String jobTitle)
    {
        return ResponseEntity.ok(jobPostService.getByJobTitle(jobTitle));
    }

    @GetMapping("/CompanyName")
    public ResponseEntity<List<JobPostDTO>> getByCompanyName(@RequestParam String companyName)
    {
        return ResponseEntity.ok(jobPostService.getByCompanyName(companyName));
    }

    @GetMapping("/JobType")
    public ResponseEntity<List<JobPostDTO>> getByJobType(@RequestParam JobType jobType)
    {
        return ResponseEntity.ok(jobPostService.getByJobType(jobType));
    }

    @GetMapping("/internal/count")
    public ResponseEntity<Long> getJobPostCount() {
        return ResponseEntity.ok(jobPostRepository.count());
    }


}
