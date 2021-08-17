package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Income;

@Repository
public class IncomeDaoImpl implements IncomeDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addIncome(Income income) {
		getSession().saveOrUpdate(income);
		System.out.println("Income entry stored Successfully in DB !!!");

	}

	@Override
	public List<Income> updateIncome(Income income) {
		// check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery(
				"update Income set incomeAmount=:incomeAmount,incomeDescription=:incomeDescription where incomeId=:incomeId");
		query.setParameter("incomeAmount", income.getIncomeAmount());
		query.setParameter("incomeDescription", income.getIncomeDescription());
		query.setParameter("incomeId", income.getIncomeId());
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + " rows");
		}

		return getAllIncome();
	}

	@Override
	public List<Income> deleteIncome(int incomeId) {
		// check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("delete from Income where incomeId=:incomeId");
		query.setParameter("incomeId", incomeId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows");
		}

		return getAllIncome();
	}

	@Override
	public List<Income> getAllIncome() {
		// checkQuery!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("from Income");
		List<Income> incomeList = query.list();
		System.out.println(incomeList);
		return incomeList;
	}

}
