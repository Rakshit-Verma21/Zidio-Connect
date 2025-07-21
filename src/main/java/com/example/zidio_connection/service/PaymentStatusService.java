package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.PaymentStatusDTO;
import com.example.zidio_connection.entity.PaymentStatus;
import com.example.zidio_connection.repository.PaymentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentStatusService
{
    @Autowired
    PaymentStatusRepository paymentStatusRepository;

    public PaymentStatusDTO assignSubscriptionPlan(PaymentStatusDTO dto) {
        PaymentStatus paymentStatus  = new PaymentStatus();
        paymentStatus.setId(dto.id);
        paymentStatus.setPlanId(dto.planId);
        paymentStatus.setSubscriptionStart(dto.subscriptionStart);
        paymentStatus.setSubscriptionEnd(dto.subscriptionEnd);
        paymentStatus.setStatus(dto.status);

//		userPaymentStatusRepository.save(paymentStatus);

        PaymentStatus saved = (PaymentStatus) paymentStatusRepository.save(paymentStatus);
        dto.id= saved.getId();
        dto.subscriptionStart=saved.getSubscriptionStart();
        dto.subscriptionEnd=saved.getSubscriptionEnd();
        dto.status=saved.getStatus();
        return dto;
    }
    public Optional<PaymentStatusDTO> getStatusByUserId(Long id){
        return paymentStatusRepository.findByUserId(id).map(status->{
            PaymentStatusDTO dto = new PaymentStatusDTO();
            dto.id=status.getId();
            dto.planId=status.getPlanId();
            dto.userId=status.getUserId();
            dto.subscriptionStart=status.getSubscriptionStart();
            dto.subscriptionEnd=status.getSubscriptionEnd();
            dto.status=status.getStatus();
            return dto;
        });
    }


}
