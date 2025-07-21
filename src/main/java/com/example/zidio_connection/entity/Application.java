package com.example.zidio_connection.entity;

import com.example.zidio_connection.Enum.Status;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "application")
public class Application
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private Long jobId;
    private Status status;

    private Date appliedDate;

    public Application() {
    }
    public Application(Long ID, Long studentId, Long jobId, Status status, Date appliedDate) {
        this.id = ID;
        this.studentId = studentId;
        this.jobId = jobId;
        this.status = status;
        this.appliedDate = appliedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }
}
