package com.example.zidio_connection.service;



import com.razorpay.Order;
import com.razorpay.RazorpayClient;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorPayService
{
    @Value("${razorpay.keyId}")
    private String Key;
    @Value("${razorpay.keySecret}")
    private String Secret;

    public String createOrder(Double amount, String Currency,String receipt)
    {
        try
        {
            RazorpayClient client = new RazorpayClient(Key,Secret);
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100);
            orderRequest.put("currency", Currency);
            orderRequest.put("receipt", receipt);
            Order order = client.orders.create(orderRequest);
            return order.toString();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Error Creating RazorPay Order: " + e.getMessage());
        }
    }

}
