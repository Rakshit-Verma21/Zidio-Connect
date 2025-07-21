package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.JobPostDTO;
import com.example.zidio_connection.Enum.JobType;
import com.example.zidio_connection.entity.JobPost;
import com.example.zidio_connection.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobPostService
{
    @Autowired
    private JobPostRepository jobPostRepository;

    public JobPostDTO postJob(JobPostDTO dto)
    {
        JobPost post=new JobPost(dto.id,
                dto.JobTitle,
                dto.JobDescription,
                dto.CompanyName,
                dto.jobType,
                dto.PostedByEmail,
                dto.PostDate);
        JobPost savedPost=jobPostRepository.save(post);
        return MapDto(savedPost);
    }
    public List<JobPostDTO> getByPostedByEmail(String email)
    {
       return jobPostRepository.findByPostedByEmail(email).stream().map(this::MapDto).collect(Collectors.toList());
    }
    public List<JobPostDTO> getByJobTitle(String title)
    {
        return jobPostRepository.findByJobTitle(title).stream().map(this::MapDto).collect(Collectors.toList());
    }

    public List<JobPostDTO> getByJobType(JobType type)
    {
        return jobPostRepository.findByJobType(type).stream().map(this::MapDto).collect(Collectors.toList());
    }
    public List<JobPostDTO> getByCompanyName(String name)
    {
        return jobPostRepository.findByCompanyName(name).stream().map(this::MapDto).collect(Collectors.toList());
    }



    private JobPostDTO MapDto(JobPost post)
    {
        return new JobPostDTO(post.getId(),
                post.getJobTitle(),
                post.getJobDescription(),
                post.getEmploymentType(),
                post.getCompanyName(),
                post.getPostedByEmail(),
                post.getPostDate());
    }

}
