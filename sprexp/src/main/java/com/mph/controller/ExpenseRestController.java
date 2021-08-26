package com.mph.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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

/**
 * 
 * @author Shishir,Sourav,Sathiya
 * 
 *
 */
@RestController
@RequestMapping(value = "/expense")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class ExpenseRestController {

	@Autowired
	ExpenseService expenseService;
	private static final Logger logger = Logger.getLogger(ExpenseRestController.class);

	
	
	@RequestMapping(value = "/registerpage", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("edit"); // actual page name

	}
	
	/**
	 * for fetching all expenses
	 * @return allexpenses 
	 */

	@GetMapping("/allexpenses")
	public ResponseEntity<List<Expense>> allExpenses() {
		
		logger.info("GETTING REQUEST FROM local host TO SHOW All Expense");
		System.out.println(logger.getName()+ "  " + logger.getLevel());
		
		
		
		PropertyConfigurator.configure(ExpenseRestController.class.getClassLoader().getResource("log4j.properties"));
		
		
		System.out.println("Log4 j configuration is SUCCESSFUL");

		List<Expense> expenselist = expenseService.getAllExpense();
		System.out.println("From Rest allexpenses : " + expenselist);

		if (expenselist.isEmpty()) {

			return new ResponseEntity<List<Expense>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Expense>>(expenselist, HttpStatus.OK);
	}
	/**
	 * @author Sourav
	 * @param expense
	 * @return
	 */

	@PostMapping("/addexpense")
	public Expense addExpense(@RequestBody Expense expense) {
		expenseService.addExpense(expense);
		return expense;
	}

	/**
	 * For updating expenses
	 * @param expense
	 * @return updated list of Expense
	 */
	@PutMapping("/updateexpense")
	public ResponseEntity<List<Expense>> updateExpense(@RequestBody Expense expense) {

		List<Expense> expenselist = expenseService.updateExpense(expense);
		System.out.println("From Rest update expense : " + expenselist);

		if (expenselist.isEmpty()) {

			return new ResponseEntity<List<Expense>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Expense>>(expenselist, HttpStatus.OK);

	}
	/**
	 * for deleting expense by expenseId
	 * @param expenseid
	 * @return list of expense after deleting specific expense
	 */
	@DeleteMapping("/deleteExpense/{id}")
	public ResponseEntity<List<Expense>> deleteExpense(@PathVariable("id") int expenseid) {

		List<Expense> expenselist = expenseService.deleteExpense(expenseid);
		System.out.println("From Rest delete expense: " + expenselist);

		if (expenselist.isEmpty()) {

			return new ResponseEntity<List<Expense>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Expense>>(expenselist, HttpStatus.OK);
	}

	
	/**
	 * for fetching expense by expense id
	 * @param expid
	 * @return  expense of specific expense id
	 */
	@GetMapping("/getExpense/{id}")
	public ResponseEntity<Expense> getEmployeeByID(@PathVariable("id") int expid) {

		Expense exp = expenseService.getExpenseById(expid);
		System.out.println("From Rest update emp : " + exp);

		if (exp == null) {

			return new ResponseEntity<Expense>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Expense>(exp, HttpStatus.OK);

	}
	/**
	 * for fetching all the expense by particular user
	 * @param userid
	 * @return list of expenses by user
	 */
	@GetMapping("/selectedexpenses/{uid}")
	public ResponseEntity<List<Expense>> selectedExpense(@PathVariable("uid") int userid) {
		
		List<Expense> expenselistselected = expenseService.getUserExpense(userid);
		System.out.println("From Rest allselectedexpenses : " + expenselistselected);
		
		if(expenselistselected.isEmpty()) {
			
			return new ResponseEntity<List<Expense>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Expense>>(expenselistselected,HttpStatus.OK);
	}

}
