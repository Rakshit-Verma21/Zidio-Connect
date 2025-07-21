package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.RecruiterDTO;
import com.example.zidio_connection.entity.Recruiter;
import com.example.zidio_connection.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService
{
    @Autowired
    private RecruiterRepository recruiterRepository;

    public RecruiterDTO createRecruiter(RecruiterDTO dto)
    {
        Recruiter recruiter = new Recruiter(dto.id,dto.name,dto.email,dto.phone,dto.company,dto.company_description,dto.company_website);
        recruiterRepository.save(recruiter);
       // dto.setId(recruiter.getId());
        return dto;

    }
    public RecruiterDTO getRecruiterByEmail(String email)
    {
        Recruiter recruiter = recruiterRepository.findByEmail(email);
        if (recruiter != null) {
            return new RecruiterDTO(recruiter.getId(), recruiter.getName(), recruiter.getEmail(), recruiter.getPhone(),
                    recruiter.getCompany(), recruiter.getCompany_description(), recruiter.getCompany_website());
        }
        return null;
    }
    public RecruiterDTO getRecruiterById(long id)
    {
        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found with ID: " + id));
        if (recruiter != null) {
            return new RecruiterDTO(recruiter.getId(), recruiter.getName(), recruiter.getEmail(), recruiter.getPhone(),
                    recruiter.getCompany(), recruiter.getCompany_description(), recruiter.getCompany_website());
        }
        return null;
    }

}
