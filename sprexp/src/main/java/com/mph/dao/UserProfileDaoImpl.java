package com.mph.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.UserProfile;
/**
 * 
 * @author Sujeet
 *
 */

@Repository
public class UserProfileDaoImpl implements UserProfileDao {

	@Autowired
	private SessionFactory sessionFactory;
/**
 * 
 * @return Session
 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
/**
 * For adding new user
 * @param userprofile
 */
	@Override
	public void addUserProfile(UserProfile userProfile) {
		getSession().saveOrUpdate(userProfile);
		System.out.println("User stored Successfully in DB !!!");

	}

	/**For updating userProfile
	 * @param userProfile
	 * @return list of users after updating user in userProfile
	 */
	@Override
	public List<UserProfile> updateUserProfile(UserProfile userProfile) {
		// check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery(
				"update UserProfile set fname=:fname,lname=:lname,email=:email,password=:password,phoneNumber=:phoneNumber where userId=:userId");
		query.setParameter("fname", userProfile.getFname());
		query.setParameter("lname", userProfile.getLname());
		query.setParameter("email", userProfile.getEmail());
		query.setParameter("password", userProfile.getPassword());
		query.setParameter("phoneNumber", userProfile.getPhoneNumber());
		query.setParameter("userId", userProfile.getUserId());
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Updated " + noofrows + " rows");
		}

		return getAllUserProfile();
	}
/**
 * For deleting user based on userId
 * @param userId
 * @return list of users after deleting specific user 
 */
	@Override
	public List<UserProfile> deleteUserProfile(int userId) {
		// check the query!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("delete from UserProfile where userId=:userId");
		query.setParameter("userId", userId);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows");
		}

		return getAllUserProfile();
	}
/**
 * For getting all users
 * @return List of users
 */
	@Override
	public List<UserProfile> getAllUserProfile() {
		// checkQuery!!!!!!!!!!!!!!!
		Query query = getSession().createQuery("from UserProfile");
		List<UserProfile> userList = query.list();
		System.out.println(userList);
		return userList;
	}
	/**
	 * Checking user data in userProfile database for validation if user exist it will return userProfile object
	 * @param email,password
	 * @return
	 */

	@Override
	public UserProfile login(String email, String password) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("from UserProfile where email=:email and password=:password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		UserProfile up = (UserProfile) query.uniqueResult();
		System.out.println("From login.." + up);
		return up;
	}
	/**
	 * Searching  from userProfile database based on email id
	 * @param email
	 */
	@Override
	public UserProfile findByEmail(String email) {
		Query query = getSession().createQuery("from UserProfile where email=:email");
		query.setParameter("email", email);
		UserProfile em = (UserProfile) query.uniqueResult();
		System.out.println("from find by Email method.." + em);
		return em;
	}
	
	/**
	 * on the basis of email id password will reset
	 * @param email,password
	 */
	@Override
	public UserProfile resetPassword(String email, String password) {

		Query query = getSession().createQuery("update UserProfile set password =:password where email=:email");
		query.setParameter("email", email);
		query.setParameter("password", password);
		int rs=query.executeUpdate();
		if(rs>0) {
			 System.out.println("Updated "+rs+ " rows");
		}

		return null;

	}

}
