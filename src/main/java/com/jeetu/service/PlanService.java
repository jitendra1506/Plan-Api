package com.jeetu.service;

import java.util.List;
import java.util.Map;

import com.jeetu.entity.Plan;



public interface PlanService {
	
	public Map<Integer,String> getplancategory();
	public boolean savePlan(Plan plan);
	public List<Plan> getAllPlans();
	public Plan getPlanById(Integer planId);
	public boolean updatePlan(Plan plan);
	public boolean deletePlanById(Integer planId);
	public boolean planStatusChange(Integer planid , String activeSw);
	
	

	}
	
	
	


