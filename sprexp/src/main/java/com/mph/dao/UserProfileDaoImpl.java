package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.UserProfile;

@Repository
public class UserProfileDaoImpl implements UserProfileDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addUserProfile(UserProfile userProfile) {
		getSession().saveOrUpdate(userProfile);
		System.out.println("User stored Successfully in DB !!!");
		
	}

	@Override
	public List<UserProfile> updateUserProfile(UserProfile userProfile) {
		//check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("update UserProfile set fname=:fname,lname=:lname,email=:email,password=:password,phoneNumber=:phoneNumber where userId=:userId");
		query.setParameter("fname", userProfile.getFname());
		query.setParameter("lname", userProfile.getLname());
		query.setParameter("email", userProfile.getEmail());
		query.setParameter("password", userProfile.getPassword());
		query.setParameter("phoneNumber", userProfile.getPhoneNumber());
		query.setParameter("userId", userProfile.getUserId());
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Updated " + noofrows + " rows");
		}
		
		return getAllUserProfile();
	}

	@Override
	public List<UserProfile> deleteUserProfile(int userId) {
		//check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("delete from UserProfile where userId=:userId");
		query.setParameter("userId", userId);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		
		return getAllUserProfile();
	}

	@Override
	public List<UserProfile> getAllUserProfile() {
		//checkQuery!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("from UserProfile");
		List<UserProfile> userList = query.list();
		System.out.println(userList);
		return userList;
	}

}
