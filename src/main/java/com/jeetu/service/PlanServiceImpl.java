package com.jeetu.service;

import java.util.HashMap;

import java.util.List;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeetu.entity.Plan;
import com.jeetu.entity.PlanCategory;
import com.jeetu.repo.PlanCategoryRepo;
import com.jeetu.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;
	@Autowired
	private PlanCategoryRepo planCategoryRepo;

	@Override
	public Map<Integer, String> getplancategory() {
		List<PlanCategory> categories = planCategoryRepo.findAll();
		Map<Integer, String> categoryMap = new HashMap<>();

		categories.forEach(category -> {
			categoryMap.put(category.getId(), category.getCatogryname());
		});

		return categoryMap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved = planRepo.save(plan);

//		if(saved.getPlanId()!= null)
//			return true;
//		else 
//		return false;

//		return saved.getPlanId()!= null ? true : false;
		return saved.getPlanId() != null;
	}

	@Override
	public List<Plan> getAllPlans() {
		return planRepo.findAll();

	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent())
			return findById.get();
		else
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan save = planRepo.save(plan); //Upsert = update+insert
		return plan.getPlanId()!=null;
		
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status = false;
try {
	planRepo.deleteById(planId);
	status =  true;
}catch(Exception e)
{
	e.printStackTrace();
}
	
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planid, String activeSw) {
		Optional<Plan> findById = planRepo.findById(planid);
		if(findById.isPresent())
		{
			Plan plan = findById.get();
			plan.setActiveSw(activeSw);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

}
