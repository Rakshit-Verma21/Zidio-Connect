package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.PaymentDTO;
import com.example.zidio_connection.entity.Payment;
import com.example.zidio_connection.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService
{
    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentDTO makePayment(PaymentDTO dto)
    {
        Payment pay = new Payment();
        pay.setId(dto.id);
        pay.setUserId(dto.userID);
        pay.setPlanId(dto.PlanID);
        pay.setAmount(dto.amount);
        pay.setCurrency(dto.currency);;
        pay.setPaymentType(dto.paymentType);
        pay.setPaymentStatus(dto.paymentStatus);
        pay.setPaymentDate(dto.paymentDate);
        pay.setTransactionId(dto.transactionId);

        Payment savedPayment = paymentRepository.save(pay);
        dto.id= savedPayment.getId();
        dto.paymentDate = savedPayment.getPaymentDate();
        dto.paymentStatus= savedPayment.getPaymentStatus();
        return dto;
    }
    public List<PaymentDTO> getAllPayments(){
        return paymentRepository.findAll().stream().map(p ->{
                    PaymentDTO dto= new PaymentDTO();
                    dto.id=p.getId();
                    dto.PlanID=p.getPlanId();
                    dto.userID=p.getUserId();
                    dto.amount=p.getAmount();
                    dto.currency=p.getCurrency();
                    dto.paymentType=p.getPaymentType();
                    dto.paymentStatus=p.getPaymentStatus();
                    dto.paymentDate=p.getPaymentDate();
                    return dto;})
                .collect(Collectors.toList());




    }



}
