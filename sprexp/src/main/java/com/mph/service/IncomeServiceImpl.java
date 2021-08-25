package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.IncomeDao;
import com.mph.entity.Income;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService{
	
	@Autowired
	IncomeDao incomeDao;

	@Override
	public void addIncome(Income income) {
		incomeDao.addIncome(income);
		
	}

	@Override
	public List<Income> updateIncome(Income income) {
		
		return incomeDao.updateIncome(income);
	}

	@Override
	public List<Income> deleteIncome(int incomeId) {
		
		return incomeDao.deleteIncome(incomeId);
	}

	@Override
	public List<Income> getAllIncome() {
	
		return incomeDao.getAllIncome();
	}

	@Override
	public Income getIncomeById(int incomeId) {
		// TODO Auto-generated method stub
		return incomeDao.getIncomeById(incomeId);
	}

	@Override
	public List<Income> getUserIncome(int userId) {
		// TODO Auto-generated method stub
		return incomeDao.getUserIncome(userId);
	}

}
