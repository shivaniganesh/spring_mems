package com.mph.sprexp;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.mph.dao.ExpenseDao;
import com.mph.dao.ExpenseDaoImpl;
import com.mph.entity.Expense;

public class deleteExpenseTest {
	
	ExpenseDao expenseDao;
	ExpenseDao expenseDaoImpl;
	
	
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
		expenseDaoImpl= new ExpenseDaoImpl();
	}
	
	@After
	public void tearDown() throws java.lang.Exception
	{
		expenseDaoImpl=null;
		System.out.println("@After calling Test method");
	}

	@Test
	public void test() {
		System.out.println("Testing if the expense id deleted! ");
		Scanner sc=new Scanner(System.in);
		System.out.println("What is the expenseId you want to check");
		int expId=sc.nextInt();
		try {
			
			Expense expData=expenseDao.getExpenseById(expId);
			
			
			assertEquals(expData.getExpenseId(),expId);
			System.out.println(expData);
		}
		catch(Exception exc){
			System.out.println("Oops!You entered the wrong data!"+exc);
		}
		
		
		finally {
			System.out.println("Product deletion verified Successfully!");
		}
    
	}

}
