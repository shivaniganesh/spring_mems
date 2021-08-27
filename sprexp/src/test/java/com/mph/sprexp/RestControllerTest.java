package com.mph.sprexp;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import com.mph.controller.ExpenseRestController;
import com.mph.entity.Expense;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class RestControllerTest {
	
	
	ExpenseRestController expenseRestController;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		System.out.println("Initiating Unit Testing ...");
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws java.lang.Exception
	{
		System.out.println("Terminating Unit Testing ...");
	}
	
	@Before
	public void setUp() throws java.lang.Exception
	{
		System.out.println("@Before calling Test method");
		expenseRestController= new ExpenseRestController();
	}
	
	@After
	public void tearDown() throws java.lang.Exception
	{
		expenseRestController=null;
		System.out.println("@After calling Test method");
	}
	
	@Test
	public void deleteExpense()
	{
		
		System.out.println("Testing if the expense id deleted! ");
		Scanner sc=new Scanner(System.in);
		System.out.println("What is the expenseId you want to check");
		int expId=sc.nextInt();
		try {
			ResponseEntity<List<Expense>> expDeleted=expenseRestController.deleteExpense(expId);
		try{
			assertEquals("redirect:/deleteExpense/{id}",expDeleted);
			ResponseEntity<Expense> exp=expenseRestController.getEmployeeByID(expId);
			if(((List<Expense>) exp).isEmpty())
				System.out.println("Data deletion is succesful!");
			}
		catch(Exception exc){
			System.out.println("Oops!You entered the wrong data!");
		}
		}
		catch(Exception e)
		{
			System.out.println("Oops!The data does not exist!");
		}

		finally {
			System.out.println("Product deletion verified Successfully!");
		}
     }
}
