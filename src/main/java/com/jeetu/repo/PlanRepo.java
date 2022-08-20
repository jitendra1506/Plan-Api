package com.jeetu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeetu.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer>{

}
