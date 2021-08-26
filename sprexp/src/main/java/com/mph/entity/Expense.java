package com.mph.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * 
 * @author Sathiya
 *
 */
@Entity
public class Expense {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int expenseId;

	private String category;


    private String createdDate;

	private long expenseAmount;

	private String expenseDescription;
	@ManyToOne
	@JoinColumn(name = "userId",referencedColumnName = "USERID")
	private UserProfile user;
	

	
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Expense(int expenseId, String category, String createdDate, long expenseAmount, String expenseDescription,
			UserProfile user) {
		super();
		this.expenseId = expenseId;
		this.category = category;
		this.createdDate = createdDate;
		this.expenseAmount = expenseAmount;
		this.expenseDescription = expenseDescription;
		this.user = user;
	}



	public int getExpenseId() {
		return expenseId;
	}



	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}



	public long getExpenseAmount() {
		return expenseAmount;
	}



	public void setExpenseAmount(long expenseAmount) {
		this.expenseAmount = expenseAmount;
	}



	public String getExpenseDescription() {
		return expenseDescription;
	}



	public void setExpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}



	public UserProfile getUser() {
		return user;
	}



	public void setUser(UserProfile user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Expense [expenseId=" + expenseId + ", category=" + category + ", createdDate=" + createdDate
				+ ", expenseAmount=" + expenseAmount + ", expenseDescription=" + expenseDescription + ", user=" + user
				+ "]";
	}
	

	
	
}
