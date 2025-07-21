package com.example.zidio_connection.DTO;

public class SubscriptionPlanDTO
{
    public Long id;
    public String name;
    public String currency;
    public Double price;
    public String description;
    public Integer durationInDays;

    public SubscriptionPlanDTO() {
    }
    public SubscriptionPlanDTO(Long id, String name, String currency, Double price, String description, Integer durationInDays) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.price = price;
        this.description = description;
        this.durationInDays = durationInDays;

    }
}
