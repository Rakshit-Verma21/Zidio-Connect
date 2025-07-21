package com.example.zidio_connection.entity;

import com.example.zidio_connection.Enum.JobType;
import jakarta.persistence.*;

@Entity
@Table(name="job_posts")
public class JobPost
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jobTitle;
    private String jobDescription;
    private String companyName;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private String postedByEmail;
    private String postDate;

    public JobPost()
    {}

    public JobPost(Long id, String jobTitle, String jobDescription, String companyName, JobType jobType, String postedByEmail, String postDate)
    {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.companyName = companyName;
        this.jobType = jobType;
        this.postedByEmail = postedByEmail;
        this.postDate = postDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public JobType getEmploymentType() {
        return jobType;
    }

    public void setEmploymentType(JobType employmentType) {
        this.jobType = employmentType;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getPostedByEmail() {
        return postedByEmail;
    }

    public void setPostedByEmail(String postedByEmail) {
        this.postedByEmail = postedByEmail;
    }
}
