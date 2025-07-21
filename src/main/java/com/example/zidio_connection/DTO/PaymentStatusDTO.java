package com.example.zidio_connection.DTO;

import com.example.zidio_connection.Enum.PaidStatus;
import com.example.zidio_connection.entity.PaymentStatus;

import java.time.LocalDate;

public class PaymentStatusDTO
{
    public Long id;
    public Long planId;
    public Long userId;
    public LocalDate subscriptionStart;
    public LocalDate subscriptionEnd;
    public PaidStatus status;


    public PaymentStatusDTO() {}
    public PaymentStatusDTO(Long id,Long planId,Long userId,LocalDate subscriptionStart,LocalDate subscriptionEnd,PaidStatus status) {
        this.id=id;
        this.planId=planId;
        this.userId=userId;
        this.subscriptionStart=subscriptionStart;
        this.subscriptionEnd=subscriptionEnd;
        this.status=status;

    }

}
