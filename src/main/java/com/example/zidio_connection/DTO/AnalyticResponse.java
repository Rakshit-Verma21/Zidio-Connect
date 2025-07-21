package com.example.zidio_connection.DTO;

public class AnalyticResponse
{
    public Long totalStudents;
    public Long totalRecruiters;
    public Long totalJobPost;
    public Long totalApplications;
    public Long totalAdmins;
    public String totalFileUpload;
    public String totalEmails;


    public AnalyticResponse()
    {}
    public AnalyticResponse(Long totalStudents, Long totalRecruiters, Long totalJobPost, Long totalApplications ,Long totalAdmins,String totalFileUplaod,String totalEmails)
    {
        this.totalStudents = totalStudents;
        this.totalRecruiters = totalRecruiters;
        this.totalJobPost = totalJobPost;
        this.totalApplications = totalApplications;
        this.totalAdmins=totalAdmins;
        this.totalFileUpload=totalFileUplaod;
        this.totalEmails=totalEmails;
    }

}

