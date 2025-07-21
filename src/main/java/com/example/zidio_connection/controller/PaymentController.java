package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.PaymentDTO;
import com.example.zidio_connection.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/payments")
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;


    @PostMapping
    public ResponseEntity<PaymentDTO> pay(@RequestBody PaymentDTO dto ){
        return ResponseEntity.ok(paymentService.makePayment(dto));
    }
    @GetMapping
    public ResponseEntity<List<PaymentDTO>>getAll(){
        return ResponseEntity.ok(paymentService.getAllPayments());
    }


}
