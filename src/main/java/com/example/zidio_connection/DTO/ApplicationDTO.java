package com.example.zidio_connection.DTO;

import com.example.zidio_connection.Enum.Status;

import java.util.Date;

public class ApplicationDTO
{
    public Long id;
    public Long studentID;
    public Long jobID;
    public Status status;
    public Date appliedDate;

    public ApplicationDTO(Long id, Long studentID, Long jobID, Status status, Date appliedDate) {
        this.id = id;
        this.studentID = studentID;
        this.jobID = jobID;
        this.status = status;
        this.appliedDate = appliedDate;
    }
}
