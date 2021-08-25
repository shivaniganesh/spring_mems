package com.mph.dao;

import java.util.List;

import com.mph.entity.Expense;
import com.mph.entity.Income;

public interface IncomeDao {

	public void addIncome(Income income);

	public List<Income> updateIncome(Income income);

	public List<Income> deleteIncome(int incomeId);

	public List<Income> getAllIncome();
	public Income getIncomeById(int incomeId);
	
	public List<Income> getUserIncome(int userId);

	// public Income getUserProfile(Income income);

	// public List<UserProfile> getIncomeById(int incomeId);
}
