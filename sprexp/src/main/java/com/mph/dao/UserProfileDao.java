package com.mph.dao;

import java.util.List;

import com.mph.entity.UserProfile;

public interface UserProfileDao {

	public void addUserProfile(UserProfile userProfile);

	public List<UserProfile> updateUserProfile(UserProfile userProfile);

	public List<UserProfile> deleteUserProfile(int userId);

	public List<UserProfile> getAllUserProfile();

	// public UserProfile getUserProfile(UserProfile userProfile);

	// public List<UserProfile> getUserProfileById(int userId);

}
