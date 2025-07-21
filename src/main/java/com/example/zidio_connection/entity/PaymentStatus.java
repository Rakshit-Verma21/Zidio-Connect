package com.example.zidio_connection.entity;

import com.example.zidio_connection.Enum.PaidStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payment_status")
public class PaymentStatus
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Long planId;
    private Long userId;
    private LocalDate subscriptionStart;
    private LocalDate subscriptionEnd;
    private PaidStatus status;

    public PaymentStatus(){}

    public PaymentStatus(Long id,Long planId,Long userId,LocalDate subscriptionStart,LocalDate subscriptionEnd,PaidStatus status) {
        this.id=id;
        this.planId=planId;
        this.userId=userId;
        this.subscriptionStart=subscriptionStart;
        this.subscriptionEnd=subscriptionEnd;
        this.status=status;

    }

    public PaidStatus getStatus() {
        return status;
    }
    public void setStatus(PaidStatus status) {
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPlanId() {
        return planId;
    }
    public void setPlanId(Long planId) {
        this.planId = planId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public LocalDate getSubscriptionStart() {
        return subscriptionStart;
    }
    public void setSubscriptionStart(LocalDate subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }
    public LocalDate getSubscriptionEnd() {
        return subscriptionEnd;
    }
    public void setSubscriptionEnd(LocalDate subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }






}
