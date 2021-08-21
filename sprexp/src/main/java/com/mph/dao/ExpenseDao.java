package com.mph.dao;

import java.util.List;

import com.mph.entity.Expense;

public interface ExpenseDao {

	public void addExpense(Expense expense);

	public List<Expense> updateExpense(Expense expense);

	public List<Expense> deleteExpense(int expenseId);

	public List<Expense> getAllExpense();
	

	

	 public Expense getExpenseById(int expenseId);
}
