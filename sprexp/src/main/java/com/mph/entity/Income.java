package com.mph.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int incomeId;

	private long incomeAmount;

	private String incomeDescription;
	@ManyToOne
	@JoinColumn(name = "userId",referencedColumnName = "userID")
	private UserProfile user;
	public Income() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Income(int incomeId, long incomeAmount, String incomeDescription, UserProfile user) {
		super();
		this.incomeId = incomeId;
		this.incomeAmount = incomeAmount;
		this.incomeDescription = incomeDescription;
		this.user = user;
	}
	public int getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(int incomeId) {
		this.incomeId = incomeId;
	}
	public long getIncomeAmount() {
		return incomeAmount;
	}
	public void setIncomeAmount(long incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	public String getIncomeDescription() {
		return incomeDescription;
	}
	public void setIncomeDescription(String incomeDescription) {
		this.incomeDescription = incomeDescription;
	}
	public UserProfile getUser() {
		return user;
	}
	public void setUser(UserProfile user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Income [incomeId=" + incomeId + ", incomeAmount=" + incomeAmount + ", incomeDescription="
				+ incomeDescription + ", user=" + user + "]";
	}
	

	

}
