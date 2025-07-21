package com.example.zidio_connection.entity;

import jakarta.persistence.*;

@Entity
@Table(name="subscription_plans")
public class SubscriptionPlan
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String currency;
    private Double price;
    private String description;
    private Integer durationInDays;
    private String razorpayOrderId;
    private String razorpayPaymentId;

    public SubscriptionPlan() {
    }

    public SubscriptionPlan(Long id, String name, String currency, Double price, String description, Integer durationInDays, String razorpayOrderId, String razorpayPaymentId) {
        this.id = id;
        this.name = name;
        this.currency = currency;
        this.price = price;
        this.description = description;
        this.durationInDays = durationInDays;
        this.razorpayOrderId = razorpayOrderId;
        this.razorpayPaymentId = razorpayPaymentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDurationInDays() {
        return durationInDays;
    }

    public void setDurationInDays(Integer durationInDays) {
        this.durationInDays = durationInDays;
    }

    public String getRazorpayOrderId() {
        return razorpayOrderId;
    }

    public void setRazorpayOrderId(String razorpayOrderId) {
        this.razorpayOrderId = razorpayOrderId;
    }

    public String getRazorpayPaymentId() {
        return razorpayPaymentId;
    }

    public void setRazorpayPaymentId(String razorpayPaymentId) {
        this.razorpayPaymentId = razorpayPaymentId;
    }
}
