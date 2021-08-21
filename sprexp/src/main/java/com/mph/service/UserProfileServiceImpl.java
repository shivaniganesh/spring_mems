package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.UserProfileDao;
import com.mph.entity.UserProfile;

/**
 * 
 * @author Sujeet
 *
 */
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao userProfileDao;

	@Override
	public void addUserProfile(UserProfile userProfile) {
		userProfileDao.addUserProfile(userProfile);
		
	}

	@Override
	public List<UserProfile> updateUserProfile(UserProfile userProfile) {
		
		return userProfileDao.updateUserProfile(userProfile);
	}

	@Override
	public List<UserProfile> deleteUserProfile(int userId) {
		
		return userProfileDao.deleteUserProfile(userId);
	}

	@Override
	public List<UserProfile> getAllUserProfile() {
		
		return userProfileDao.getAllUserProfile();
	}

	@Override
	public UserProfile login(String email, String password) {
		// TODO Auto-generated method stub
		return userProfileDao.login(email, password);
	}

	@Override
	public UserProfile findByEmail(String email) {
		// TODO Auto-generated method stub
		return userProfileDao.findByEmail(email);
	}

	@Override
	public UserProfile resetPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userProfileDao.resetPassword(email, password);
	}

}
