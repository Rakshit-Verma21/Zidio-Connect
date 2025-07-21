package com.example.zidio_connection.DTO;

public class RecruiterDTO
{
    public long id;
    public String name;
    public String email;
    public String phone;
    public String company;
    public String company_description;
    public String company_website;

    public RecruiterDTO(long id, String name, String email, String phone, String company, String company_description, String company_website) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.company_description = company_description;
        this.company_website = company_website;
    }
}
