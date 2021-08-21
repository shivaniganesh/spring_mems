package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.ExpenseDao;
import com.mph.entity.Expense;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService{

	@Autowired
	ExpenseDao expenseDao;
	
	@Override
	public void addExpense(Expense expense) {
		expenseDao.addExpense(expense);
		
	}

	@Override
	public List<Expense> updateExpense(Expense expense) {
		
		return expenseDao.updateExpense(expense);
	}

	@Override
	public List<Expense> deleteExpense(int expenseId) {
		
		return expenseDao.deleteExpense(expenseId);
	}

	@Override
	public List<Expense> getAllExpense() {
		
		return expenseDao.getAllExpense();
	}

	@Override
	public Expense getExpenseById(int expenseId) {
		// TODO Auto-generated method stub
		return expenseDao.getExpenseById(expenseId);
	}



}
