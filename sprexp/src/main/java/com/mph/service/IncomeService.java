package com.mph.service;

import java.util.List;

import com.mph.entity.Income;


public interface IncomeService {
	public void addIncome(Income income);

	public List<Income> updateIncome(Income income);

	public List<Income> deleteIncome(int incomeId);

	public List<Income> getAllIncome();
	public Income getIncomeById(int incomeId);

	public List<Income> getUserIncome(int userId);

}
