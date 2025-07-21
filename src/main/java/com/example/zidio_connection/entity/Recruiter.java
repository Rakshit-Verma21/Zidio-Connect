package com.example.zidio_connection.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recruiters")
public class Recruiter
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String phone;
    private String company;
    private String company_description;
    private String company_website;

    public Recruiter()
    {}

    public Recruiter(long id, String name, String email, String phone, String company, String company_description, String company_website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.company_description = company_description;
        this.company_website = company_website;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany_description() {
        return company_description;
    }

    public void setCompany_description(String company_description) {
        this.company_description = company_description;
    }

    public String getCompany_website() {
        return company_website;
    }

    public void setCompany_website(String company_website) {
        this.company_website = company_website;
    }
}
