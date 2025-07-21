package com.example.zidio_connection.controller;
import com.example.zidio_connection.DTO.SubscriptionPlanDTO;
import com.example.zidio_connection.service.SubscriptionPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription-plans")
public class SubscriptionPlanController
{
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    @GetMapping
    public ResponseEntity<List<SubscriptionPlanDTO>> getAllSubscriptionPlans() {
        List<SubscriptionPlanDTO> plans = subscriptionPlanService.getAllSubscriptionPlans();
        return ResponseEntity.ok(plans);
    }
    @PostMapping
    public ResponseEntity<SubscriptionPlanDTO> createSubscriptionPlan(@RequestParam  SubscriptionPlanDTO subscriptionPlanDTO) {
        SubscriptionPlanDTO createdPlan = subscriptionPlanService.createSubscription(subscriptionPlanDTO);
        return ResponseEntity.status(201).body(createdPlan);
    }
    @GetMapping("/plan_name/{name}")
    public ResponseEntity<List<SubscriptionPlanDTO>> getSubscriptionPlanByName(@PathVariable String name) {
        List<SubscriptionPlanDTO> plans = subscriptionPlanService.getSubscriptionPlanByName(name);
        return ResponseEntity.ok(plans);
    }
    @GetMapping("/plan_duration/{durationInDays}")
    public ResponseEntity<List<SubscriptionPlanDTO>> getSubscriptionPlanByDurationInDays(@PathVariable Integer durationInDays) {
        List<SubscriptionPlanDTO> plans = subscriptionPlanService.getSubscriptionPlanByDurationInDays(durationInDays);
        return ResponseEntity.ok(plans);
    }
    @GetMapping("/plan_price/{price}")
    public ResponseEntity<List<SubscriptionPlanDTO>> getSubscriptionPlanByPrice(@PathVariable Double price) {
        List<SubscriptionPlanDTO> plans = subscriptionPlanService.getSubscriptionPlanByPrice(price);
        return ResponseEntity.ok(plans);
    }



}
