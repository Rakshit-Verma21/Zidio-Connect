package com.example.zidio_connection.DTO;


public class StudentDTO
{
    public long id;
    public String name;
    public String email;
    public String phone;
    public String qualifications;
    public String resumeURL;

    public StudentDTO(long id, String name, String email, String phone, String qualifications, String resumeURL) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualifications = qualifications;
        this.resumeURL = resumeURL;
    }

}

