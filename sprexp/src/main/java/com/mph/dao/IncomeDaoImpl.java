package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Income;

/**
 * 
 * @author Shivani
 *
 */
@Repository
public class IncomeDaoImpl implements IncomeDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	/**
	 * for adding income
	 * @param income
	 */
	public void addIncome(Income income) {
		getSession().saveOrUpdate(income);
		System.out.println("Income entry stored Successfully in DB !!!");

	}

	@Override
	/**
	 * for updating income
	 * @param income
	 */
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
	/**
	 * for deleting income by income id
	 * @param incomeId
	 */
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
	/**
	 * for fetching all income
	 * 
	 */
	public List<Income> getAllIncome() {
		// checkQuery!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("from Income");
		List<Income> incomeList = query.list();
		System.out.println(incomeList);
		return incomeList;
	}

	@Override
	/**
	 * for fetching a specific income by incomeId
	 * @param incomeId
	 */
	public Income getIncomeById(int incomeId) {
		Criteria c = getSession().createCriteria(Income.class);
		c.add(Restrictions.eq("incomeId", incomeId));
		Income inc = (Income) c.uniqueResult();
		System.out.println("Income Retrieved : " + inc);
		return inc;
	}

	@Override
	/**
	 * for fetching all income for a specific user by userId
	 * @param userId
	 */
	public List<Income> getUserIncome(int userId) {
		// TODO Auto-generated method stub
		
		Query query = getSession().createQuery("from Income Income where userId=:uid");
		query.setParameter("uid", userId);
		

		List<Income> IncomeListSelected = query.list();
		System.out.println(IncomeListSelected);
		return IncomeListSelected;
		
	}


}
