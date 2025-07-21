package com.example.zidio_connection.repository;

import com.example.zidio_connection.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlan, Long>
{
    List<SubscriptionPlan> findByName(String name);
    List<SubscriptionPlan> findByPrice(Double price);
    List<SubscriptionPlan> findByDurationInDays(Integer durationInDays);



}
