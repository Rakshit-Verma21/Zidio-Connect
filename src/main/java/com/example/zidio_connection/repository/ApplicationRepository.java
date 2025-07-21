package com.example.zidio_connection.repository;

import com.example.zidio_connection.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>
{
    List<Application> findByStudentId(Long studentId);
    List<Application> findByJobId(Long jobId);
    Optional<Application> findById(Long id);

}
