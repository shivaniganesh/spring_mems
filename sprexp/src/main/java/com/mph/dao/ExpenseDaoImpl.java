package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Expense;


@Repository
public class ExpenseDaoImpl implements ExpenseDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addExpense(Expense expense) {
		getSession().saveOrUpdate(expense);
		System.out.println("Expense entry stored Successfully in DB !!!");

	}

	@Override
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
	public List<Expense> getAllExpense() {
		// checkQuery!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("from Expense");
		List<Expense> expenseList = query.list();
		System.out.println(expenseList);
		return expenseList;
	}

}
