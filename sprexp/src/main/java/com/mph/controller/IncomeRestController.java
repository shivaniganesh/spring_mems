package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Income;
import com.mph.entity.UserProfile;
import com.mph.service.IncomeService;


@RestController
@RequestMapping(value = "/income")
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class IncomeRestController {
	
	@Autowired
	IncomeService incomeService;
	
	@GetMapping("/allIncomes")
	public ResponseEntity<List<Income>> allIncome() {
		
		List<Income> incomelist = incomeService.getAllIncome();
		System.out.println("From Rest allincomes : " + incomelist);
		
		if(incomelist.isEmpty()) {
			
			return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Income>>(incomelist,HttpStatus.OK);		
	}
	
	@PostMapping("/addIncome")
	public Income addIncome(@RequestBody Income income) {
		incomeService.addIncome(income);
		return income;
	}

	@PutMapping("/updateIncome")
	public ResponseEntity<List<Income>> updateIncome(@RequestBody Income income) {
		
		List<Income> incomelist = incomeService.updateIncome(income);
		System.out.println("From Rest update income : " + incomelist);
		
		if(incomelist.isEmpty()) {
			
			return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Income>>(incomelist,HttpStatus.OK);		
		
	}
	
	@DeleteMapping("/deleteIncome/{id}")
	public ResponseEntity<List<Income>> deleteIncome(@PathVariable("id") int incomeid) {
		
		List<Income> incomelist = incomeService.deleteIncome(incomeid);
		System.out.println("From Rest delete income: " + incomelist);
		
		if(incomelist.isEmpty()) {
			
			return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Income>>(incomelist,HttpStatus.OK);		
	}
}
