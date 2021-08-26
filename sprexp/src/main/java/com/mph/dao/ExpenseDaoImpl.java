package com.mph.dao;

import java.util.List;

import org.eclipse.jface.text.templates.GlobalTemplateVariables.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Expense;

/**
 * 
 * @author Sathiya,Sourav,Shishir,Shivani,Sujeet
 *
 */
@Repository
public class ExpenseDaoImpl implements ExpenseDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	/**
	 * 
	 * for adding expense
	 * @param expense
	 */
	public void addExpense(Expense expense) {
		getSession().saveOrUpdate(expense);
		System.out.println("Expense entry stored Successfully in DB !!!");

	}


	@Override
	/**
	 * for updating expense
	 * @param expense
	 */
	public List<Expense> updateExpense(Expense expense) {
		// check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery(
				"update Expense set category=:category,createdDate=:createdDate,expenseAmount=:expenseAmount,expenseDescription=:expenseDescription where expenseId=:expenseId");
		query.setParameter("category", expense.getCategory());
		query.setParameter("createdDate", expense.getCreatedDate());
		query.setParameter("expenseAmount", expense.getExpenseAmount());
		query.setParameter("expenseDescription", expense.getExpenseDescription());
		query.setParameter("expenseId", expense.getExpenseId());
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + " rows");
		}

		return getAllExpense();
	}

	@Override
	/**
	 * for deleting expense by expenseId
	 * @param expenseid
	 */
	public List<Expense> deleteExpense(int expenseId) {
		// check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("delete from Expense where expenseId=:expenseId");
		query.setParameter("expenseId", expenseId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows");
		}

		return getAllExpense();
	}

	@Override
	/**
	 * for fetching all expenses without any conditions
	 */
	public List<Expense> getAllExpense() {
		// checkQuery!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("from Expense");
		List<Expense> expenseList = query.list();
		System.out.println(expenseList);
		return expenseList;
	}

	@Override
	/**
	 * for fetching a particular expense by expenseId
	 * @param expenseid
	 */
	public Expense getExpenseById(int expenseId) {
		Criteria c = getSession().createCriteria(Expense.class);
		c.add(Restrictions.eq("expenseId", expenseId));
		Expense exp = (Expense) c.uniqueResult();
		System.out.println("Employee Retrieved : " + exp);
		return exp;
	}

	@Override
	/**
	 * for fetching all expense by  for a specific user
	 * @param userid
	 */
	public List<Expense> getUserExpense(int userId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from Expense expense where userId=:uid");
		query.setParameter("uid", userId);
		

		List<Expense> expenseListSelected = query.list();
		System.out.println(expenseListSelected);
		return expenseListSelected;
	}



}
