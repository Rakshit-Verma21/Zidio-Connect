package com.example.zidio_connection.entity;

import jakarta.persistence.*;
import jdk.jshell.Snippet;

@Entity
@Table(name="students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String email;
    private String qualifications;
    private String phone;
    private String resumeURL;

    public Student()
    {

    }
    public Student(long id, String name, String email, String phone, String qualifications, String resumeURL)
    {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.qualifications = qualifications;
        this.resumeURL = resumeURL;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQualifications() {
        return qualifications;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }
}
