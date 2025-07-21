package com.example.zidio_connection.controller;

import com.example.zidio_connection.service.RazorPayService;
import com.razorpay.RazorpayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SignatureException;
import java.util.Base64;

@RestController
@RequestMapping("/api/razorpay")
public class RazorPayController {
    @Autowired
    private RazorPayService razorPayService;

    @PostMapping("payment/webhook")
    public ResponseEntity<String> handleWebHook(@RequestBody String payload, @RequestHeader("X-Razorpay-Signature") String signature)
    {
        String secret="zidio_connection_webhook_secret";

           if(isSignatureValid(payload, signature, secret))
           {
               return ResponseEntity.ok("Webhook received successfully");
           }
           else
           {
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid signature");
           }
    }
    @PostMapping("create-order")
    public ResponseEntity<String> createOrder(@RequestParam Double amount,@RequestParam String currency,@RequestParam String receipt)
    {
        try
        {
          String orderJson = razorPayService.createOrder(amount, currency, receipt);
          return ResponseEntity.ok(orderJson);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order");
        }
    }
    public static boolean isSignatureValid(String payload, String actualSignature, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            byte[] hash = sha256_HMAC.doFinal(payload.getBytes());
            String expectedSignature = new String(Base64.getEncoder().encode(hash));

            return expectedSignature.equals(actualSignature);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



}
