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
import org.springframework.web.servlet.ModelAndView;

import com.mph.entity.Expense;
import com.mph.service.ExpenseService;


@RestController
@RequestMapping(value = "/expense")
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ExpenseRestController {
	
	@Autowired
	ExpenseService expenseService;
	
	@RequestMapping(value = "/registerpage",method = RequestMethod.GET)
	public ModelAndView register()
	{
		return new ModelAndView("edit");		// actual page name
		
	}
	
	@GetMapping("/allexpenses")
	public ResponseEntity<List<Expense>> allIncome() {
		
		List<Expense> expenselist = expenseService.getAllExpense();
		System.out.println("From Rest allexpenses : " + expenselist);
		
		if(expenselist.isEmpty()) {
			
			return new ResponseEntity<List<Expense>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Expense>>(expenselist,HttpStatus.OK);		
	}
	
	@PostMapping("/addexpense")
	public Expense addExpense(@RequestBody Expense expense) {
		expenseService.addExpense(expense);
		return expense;
	}
	
	@PutMapping("/updateexpense")
	public ResponseEntity<List<Expense>> updateExpense(@RequestBody Expense expense) {
		
		List<Expense> expenselist = expenseService.updateExpense(expense);
		System.out.println("From Rest update expense : " + expenselist);
		
		if(expenselist.isEmpty()) {
			
			return new ResponseEntity<List<Expense>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Expense>>(expenselist,HttpStatus.OK);		
		
	}
	
	@DeleteMapping("/deleteExpense/{id}")
	public ResponseEntity<List<Expense>> deleteExpense(@PathVariable("id") int expenseid) {
		
		List<Expense> expenselist = expenseService.deleteExpense(expenseid);
		System.out.println("From Rest delete expense: " + expenselist);
		
		if(expenselist.isEmpty()) {
			
			return new ResponseEntity<List<Expense>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Expense>>(expenselist,HttpStatus.OK);		
	}

}
