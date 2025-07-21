package com.example.zidio_connection.entity;

import com.example.zidio_connection.Enum.PaidStatus;
import com.example.zidio_connection.Enum.PaymentType;
import com.example.zidio_connection.Enum.ServiceType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name="invoice")
public class Invoice
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    private ServiceType serviceType;
    private Double amount;
    private LocalDateTime purchaseDate= LocalDateTime.now();
    private PaymentType paymentMethod;
    private PaidStatus status;
    private String invoiceNumber;
    private String subscriptionPlan;

    public Invoice() {
    }
    public Invoice(String userEmail, ServiceType serviceType, Double amount, PaymentType paymentMethod, PaidStatus status, String invoiceNumber, String subscriptionPlan) {
        this.userEmail = userEmail;
        this.serviceType = serviceType;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.invoiceNumber = invoiceNumber;
        this.subscriptionPlan = subscriptionPlan;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }
    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public PaymentType getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentType paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaidStatus getStatus() {
        return status;
    }

    public void setStatus(PaidStatus status) {
        this.status = status;
    }
}
