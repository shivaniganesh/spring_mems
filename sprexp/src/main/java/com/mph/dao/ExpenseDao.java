package com.mph.dao;

import java.util.List;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.User;
import org.hibernate.Query;

import com.mph.entity.Expense;

/**
 * 
 * @author Shishir
 *
 */
public interface ExpenseDao {

	public void addExpense(Expense expense);

	public List<Expense> updateExpense(Expense expense);

	public List<Expense> deleteExpense(int expenseId);

	public List<Expense> getUserExpense(int userId);
	
	
	public List<Expense> getAllExpense();
	
	



	 public Expense getExpenseById(int expenseId);
}
