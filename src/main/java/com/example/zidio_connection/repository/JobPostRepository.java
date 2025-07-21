package com.example.zidio_connection.repository;

import com.example.zidio_connection.Enum.JobType;
import com.example.zidio_connection.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, Long>
{
    List<JobPost> findByPostedByEmail(String postedByEmail);
    List<JobPost> findByJobTitle(String jobTitle);
    List<JobPost> findByCompanyName(String companyName);
    List<JobPost> findByJobType(JobType jobType);


}
