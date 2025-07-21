package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.ApplicationDTO;
import com.example.zidio_connection.Enum.Status;
import com.example.zidio_connection.entity.Application;
import com.example.zidio_connection.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;


    public ApplicationDTO apply(ApplicationDTO applicationDTO) {
        Application application = new Application();
        application.setId(applicationDTO.id);
        application.setStudentId(applicationDTO.studentID);
        application.setAppliedDate(applicationDTO.appliedDate);
        application.setJobId(applicationDTO.jobID);
        application.setStatus(applicationDTO.status);

        Application saved = (Application) applicationRepository.save(application);

        return new ApplicationDTO(
                saved.getId(),
                saved.getStudentId(),
                saved.getJobId(),
                saved.getStatus(),
                saved.getAppliedDate());
    }

    public List<ApplicationDTO> getApplicationByStudentID(Long StudentId) {
        List<Application> applications = applicationRepository.findByStudentId(StudentId);
        return applications.stream().map(application -> new ApplicationDTO(
                application.getId(),
                application.getStudentId(),
                application.getJobId(),
                application.getStatus(),
                application.getAppliedDate())).collect(Collectors.toList());
    }

    public List<ApplicationDTO> getApplicationByJobID(Long JobId) {
        List<Application> applications = applicationRepository.findByJobId(JobId);
        return applications.stream().map(application -> new ApplicationDTO(
                application.getId(),
                application.getStudentId(),
                application.getJobId(),
                application.getStatus(),
                application.getAppliedDate())).collect(Collectors.toList());
    }

    public void updateApplicationStatus(Long applicationId, Status status) {
        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found with ID: " + applicationId));
        application.setStatus(status);
        applicationRepository.save(application);
    }
}
