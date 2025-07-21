package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.PaymentStatusDTO;
import com.example.zidio_connection.service.PaymentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("api/subscription_status")
public class PaymentStatusController
{

    @Autowired
    private PaymentStatusService userPaymentStatusService;


    @PostMapping
    public ResponseEntity<PaymentStatusDTO> assign(@RequestBody PaymentStatusDTO dto ){
        return ResponseEntity.ok(userPaymentStatusService.assignSubscriptionPlan(dto));
    }

    @GetMapping("/find_by/{userId}")
    public ResponseEntity<Optional<PaymentStatusDTO>> getStatus(@PathVariable Long userId){
        return ResponseEntity.ok(userPaymentStatusService.getStatusByUserId(userId));
    }
}
