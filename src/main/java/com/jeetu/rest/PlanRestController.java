package com.jeetu.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeetu.entity.Plan;
import com.jeetu.service.PlanService;
import com.jeetu.service.PlanServiceImpl;

@RestController
public class PlanRestController {
	@Autowired
	private PlanService planService;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getPlanCategory() {
		Map<Integer, String> planCategory = planService.getplancategory();
		return new ResponseEntity<>(planCategory, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String responseMsg = "";
		boolean isSaved = planService.savePlan(plan);
		if (isSaved)
			responseMsg = "plan saved successfully";
		else
			responseMsg = "plan  note saved";
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}
    
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans() {

		List<Plan> plans = planService.getAllPlans();
		return new ResponseEntity<>(plans, HttpStatus.OK);
	}
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
	   	Plan plan = planService.getPlanById(planId);
	   	return new ResponseEntity<>(plan ,HttpStatus.OK);
}
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId){
		
		boolean isDeleted = planService.deletePlanById(planId);
		String responseMsg ="";
		if(isDeleted )
		{
			 responseMsg="record  deleted successfully";
		}else {
			responseMsg= "record not deleted";
		}
	   	return new ResponseEntity<>(responseMsg ,HttpStatus.OK);


	}
	@PutMapping("/plan")
	 public ResponseEntity<String> updateplan(@RequestBody Plan plan){
                   boolean isUpdate = planService.updatePlan(plan);
                   String responseMsg ="";
           		if(isUpdate )
           		{
           			 responseMsg="record  updated successfully";
           		}else {
           			responseMsg= "record not updated";
           		}
           	   	return new ResponseEntity<>(responseMsg ,HttpStatus.OK);
 
	 }
	@PutMapping("/status_change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId,@PathVariable String status){
		boolean isStatusChanged = planService.planStatusChange( planId, status);
		String responseMsg ="";
   		if(isStatusChanged )
   		{
   			 responseMsg="status  changed successfully";
   		}else {
   			responseMsg= "status not change";
   		}
   	   	return new ResponseEntity<>(responseMsg ,HttpStatus.OK);

	}
}