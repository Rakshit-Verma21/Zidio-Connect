package com.example.zidio_connection.controller;

import com.example.zidio_connection.DTO.InvoiceDTO;
import com.example.zidio_connection.Enum.ServiceType;
import com.example.zidio_connection.entity.Invoice;
import com.example.zidio_connection.service.BillingService;
import com.example.zidio_connection.service.RazorPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
public class BillingController
{
    @Autowired
    private BillingService billingService;

    @Autowired
    private RazorPayService razorPayService;

    @PostMapping("/pay")
    public ResponseEntity<Invoice> createInvoice(InvoiceDTO dto) {
        Invoice invoice = billingService.createInvoice(dto);
        return ResponseEntity.ok(invoice);
    }
    @GetMapping("/download/{subscriptionPlan}")
    public ResponseEntity<byte[]>  downloadInvoice(@PathVariable Long subscriptionPLan)
    {
        byte[] bytes=billingService.generateInvoice(subscriptionPLan);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "invoice.pdf");

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);



    }
    @GetMapping("/history/{userEmail}")
    public ResponseEntity<List<Invoice>> getInvoiceByEmail(String userEmail) {
        List<Invoice> invoices = billingService.getInvoiceByEmail(userEmail);
        return ResponseEntity.ok(invoices);
    }
    @GetMapping("/history/{serviceType}")
    public ResponseEntity<List<Invoice>> getInvoicesByServiceType(ServiceType serviceType) {
        List<Invoice> invoices = billingService.getInvoicesByServiceType(serviceType);
        return ResponseEntity.ok(invoices);
    }
    @GetMapping("/history/{userEmail}/{serviceType}")
    public ResponseEntity<List<Invoice>> getInvoicesByEmailAndServiceType(String userEmail, ServiceType serviceType) {
        List<Invoice> invoices = billingService.getInvoiceByEmail(userEmail);
        invoices.retainAll(billingService.getInvoicesByServiceType(serviceType));
        return ResponseEntity.ok(invoices);
    }




}
