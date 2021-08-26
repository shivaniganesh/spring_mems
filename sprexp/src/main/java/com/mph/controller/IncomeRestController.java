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

import com.mph.entity.Income;
import com.mph.entity.Income;
import com.mph.entity.UserProfile;
import com.mph.service.IncomeService;
/**
 * 
 * @author Shivani
 *
 */

@RestController
@RequestMapping(value = "/income")
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class IncomeRestController {
	
	@Autowired
	IncomeService incomeService;
	private static final Logger logger = Logger.getLogger(IncomeRestController.class);
	
	/**
	 * for fetching all incomes
	 * @return all incomes
	 */
	@GetMapping("/allIncomes")
	public ResponseEntity<List<Income>> allIncome() {

		logger.info("GETTING REQUEST FROM local host TO SHOW All Incomes");
		System.out.println(logger.getName()+ "  " + logger.getLevel());
		
		
		
		PropertyConfigurator.configure(IncomeRestController.class.getClassLoader().getResource("log4j.properties"));
		
		
		System.out.println("Log4 j configuration is SUCCESSFUL");

		
		List<Income> incomelist = incomeService.getAllIncome();
		System.out.println("From Rest allincomes : " + incomelist);
		
		if(incomelist.isEmpty()) {
			
			return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Income>>(incomelist,HttpStatus.OK);		
	}
	
	/**
	 * for Adding income
	 * @param income
	 * @return income
	 */
	@PostMapping("/addIncome")
	public Income addIncome(@RequestBody Income income) {
		incomeService.addIncome(income);
		return income;
	}
	
	/**
	 * for updating income
	 * @param income
	 * @return list of income after updating
	 */

	@PutMapping("/updateIncome")
	public ResponseEntity<List<Income>> updateIncome(@RequestBody Income income) {
		
		List<Income> incomelist = incomeService.updateIncome(income);
		System.out.println("From Rest update income : " + incomelist);
		
		if(incomelist.isEmpty()) {
			
			return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Income>>(incomelist,HttpStatus.OK);		
		
	}
	/**
	 * for Deleting income by id
	 * @param incomeid
	 * @return  return list of income after deleting income
	 */
	
	@DeleteMapping("/deleteIncome/{id}")
	public ResponseEntity<List<Income>> deleteIncome(@PathVariable("id") int incomeid) {
		
		List<Income> incomelist = incomeService.deleteIncome(incomeid);
		System.out.println("From Rest delete income: " + incomelist);
		
		if(incomelist.isEmpty()) {
			
			return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Income>>(incomelist,HttpStatus.OK);		
	}
	
	/**
	 * for get income by id
	 * @param incomeId
	 * @return income of specific income id
	 */
	
	@GetMapping("/getIncome/{id}")
	public ResponseEntity<Income> getIncomeByID(@PathVariable("id") int incomeId) {

		Income inc = incomeService.getIncomeById(incomeId);
		System.out.println("From Rest income emp : " + inc);

		if (inc == null) {

			return new ResponseEntity<Income>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Income>(inc, HttpStatus.OK);

	}
	
	/**
	 * for fetching all incomes based on userId which is foreign key
	 * @param userid
	 * @return all income of particular userId
	 */
	@GetMapping("/selectedincomes/{uid}")
	public ResponseEntity<List<Income>> selectedIncome(@PathVariable("uid") int userid) {
		
		List<Income> Incomelistselected = incomeService.getUserIncome(userid);
		System.out.println("From Rest allselectedIncomes : " + Incomelistselected);
		
		if(Incomelistselected.isEmpty()) {
			
			return new ResponseEntity<List<Income>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Income>>(Incomelistselected,HttpStatus.OK);
	}
}
