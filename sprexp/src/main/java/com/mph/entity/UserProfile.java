package com.mph.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	private String fname;
	
	private String lname;
	@Column(unique=true)
	private String email;
	
	private String password;
	
	private long phoneNumber;
	
	//@OneToMany(cascade=CascadeType.ALL)
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<Income> income;

	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private Set<Expense> expense;
	

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(int userId, String fname, String lname, String email, String password, long phoneNumber) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	

	@Override
	public String toString() {
		return "UserProfile [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}

}
