package com.example.zidio_connection.DTO;


import com.example.zidio_connection.Enum.JobType;

public class JobPostDTO
{
    public Long id;
    public String JobTitle;
    public String JobDescription;
    public JobType jobType;
    public String CompanyName;
    public String PostedByEmail;
    public String PostDate;

    public  JobPostDTO(Long id, String jobTitle, String jobDescription, JobType jobType, String companyName, String postedByEmail, String postDate) {
        this.id = id;
        this.JobTitle = jobTitle;
        this.JobDescription = jobDescription;
        this.jobType = jobType;
        this.CompanyName = companyName;
        this.PostedByEmail = postedByEmail;
        this.PostDate = postDate;
    }
}
