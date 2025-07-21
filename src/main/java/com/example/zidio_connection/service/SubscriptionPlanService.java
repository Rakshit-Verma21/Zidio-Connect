package com.example.zidio_connection.service;

import com.example.zidio_connection.DTO.SubscriptionPlanDTO;
import com.example.zidio_connection.entity.SubscriptionPlan;
import com.example.zidio_connection.repository.SubscriptionPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionPlanService
{
    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public List<SubscriptionPlanDTO> getAllSubscriptionPlans()
    {
        return subscriptionPlanRepository.findAll()
                .stream()
                .map(plan -> new SubscriptionPlanDTO(
                        plan.getId(),
                        plan.getName(),
                        plan.getCurrency(),
                        plan.getPrice(),
                        plan.getDescription(),
                        plan.getDurationInDays()
                      ))
                .collect(Collectors.toList());
    }
    public SubscriptionPlanDTO createSubscription(SubscriptionPlanDTO dto)
    {
        SubscriptionPlan subscriptionPlan=new SubscriptionPlan();
        subscriptionPlan.setName(dto.name);
        subscriptionPlan.setCurrency(dto.currency);
        subscriptionPlan.setPrice(dto.price);
        subscriptionPlan.setDescription(dto.description);
        subscriptionPlan.setDurationInDays(dto.durationInDays);
        SubscriptionPlan savedPlan = subscriptionPlanRepository.save(subscriptionPlan);
        dto.id= savedPlan.getId();
        return dto;
    }
    public List<SubscriptionPlanDTO> getSubscriptionPlanByName(String name)
    {
        return subscriptionPlanRepository.findByName(name).stream().map(this::MapDto).collect(Collectors.toList());
    }
    public List<SubscriptionPlanDTO> getSubscriptionPlanByPrice(Double price)
    {
        return subscriptionPlanRepository.findByPrice(price).stream().map(this::MapDto).collect(Collectors.toList());
    }
    public List<SubscriptionPlanDTO> getSubscriptionPlanByDurationInDays(Integer durationInDays)
    {
        return subscriptionPlanRepository.findByDurationInDays(durationInDays).stream().map(this::MapDto).collect(Collectors.toList());
    }


    private SubscriptionPlanDTO MapDto(SubscriptionPlan subscriptionPlan)
    {
        return new SubscriptionPlanDTO(
                subscriptionPlan.getId(),
                subscriptionPlan.getName(),
                subscriptionPlan.getCurrency(),
                subscriptionPlan.getPrice(),
                subscriptionPlan.getDescription(),
                subscriptionPlan.getDurationInDays()
        );
    }

}
