package com.example.zidio_connection.DTO;

import com.example.zidio_connection.Enum.PaidStatus;
import com.example.zidio_connection.Enum.PaymentType;
import com.example.zidio_connection.Enum.ServiceType;

import java.time.LocalDateTime;

public class InvoiceDTO
{
   public Long id;
   public String userEmail;
   public ServiceType serviceType;
   public Double amount;
   public LocalDateTime purchaseDate = LocalDateTime.now();
   public PaymentType paymentMethod;
   public PaidStatus status;
    public String invoiceNumber;
    public String subscriptionPlan;

    public InvoiceDTO() {
    }
    public InvoiceDTO(String userEmail, ServiceType serviceType, Double amount, PaymentType paymentMethod, PaidStatus status, String invoiceNumber, String subscriptionPlan) {
        this.userEmail = userEmail;
        this.serviceType = serviceType;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.invoiceNumber = invoiceNumber;
        this.subscriptionPlan = subscriptionPlan;
    }

}
