package com.example.zidio_connection.DTO;

import com.example.zidio_connection.Enum.PaidStatus;
import com.example.zidio_connection.Enum.PaymentType;
import com.example.zidio_connection.entity.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentDTO
{
    public Long id;
    public Long userID;
    public Long PlanID;
    public String transactionId;
    public BigDecimal amount;
    public String currency;
    public PaidStatus paymentStatus;
    public PaymentType paymentType;
    public LocalDateTime paymentDate;

    public PaymentDTO() {
    }
    public PaymentDTO(Long id, Long userID, Long planID, String transactionId, BigDecimal amount, String currency, PaidStatus paymentStatus, PaymentType paymentType, LocalDateTime paymentDate) {
        this.id = id;
        this.userID = userID;
        this.PlanID = planID;
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
        this.paymentStatus = paymentStatus;
        this.paymentType = paymentType;
        this.paymentDate = paymentDate;
    }
}
