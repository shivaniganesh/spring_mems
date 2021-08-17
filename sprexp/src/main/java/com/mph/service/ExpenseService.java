package com.mph.service;

import java.util.List;

import com.mph.entity.Expense;


public interface ExpenseService {

	public void addExpense(Expense expense);

	public List<Expense> updateExpense(Expense expense);

	public List<Expense> deleteExpense(int expenseId);

	public List<Expense> getAllExpense();

	// public Expense getExpense(Expense expense);

	// public List<Expense> getExpenseById(int expenseId);
}
