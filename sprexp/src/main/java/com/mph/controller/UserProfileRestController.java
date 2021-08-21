package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.UserProfile;
import com.mph.service.UserProfileService;
/**
 * 
 * @author Sujeet
 *
 */
@RestController
@RequestMapping(value = "/userProfile")
@CrossOrigin(origins="http://localhost:4200",methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserProfileRestController {
	
	@Autowired
	UserProfileService userProfileService;
	
	/**
	 * For Fetching  all users
	 * @return list of userData
	 */
	@GetMapping("/allusers")
	public ResponseEntity<List<UserProfile>> allUserProfile() {
		
		List<UserProfile> userProfilelist = userProfileService.getAllUserProfile();
		System.out.println("From Rest allusers : " + userProfilelist);
		
		if(userProfilelist.isEmpty()) {
			
			return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserProfile>>(userProfilelist,HttpStatus.OK);		
	}
	
	/**
	 * For adding new user
	 * @param userProfile
	 * @return user object if email does not exist already else throws exception
	 * @throws Exception
	 */
	@PostMapping("/addUserProfile")
	public UserProfile addUserProfile(@RequestBody UserProfile userProfile) throws Exception {
		
		String tempEmail=userProfile.getEmail();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			UserProfile userData=userProfileService.findByEmail(tempEmail);
			if(userData!=null) {
				throw new Exception("User with email:"+tempEmail+" already exist!");
				
			}
			
		}
		
		userProfileService.addUserProfile(userProfile);
		return userProfile;
	}
	
	/**
	 * for updating userProfile
	 * @param userProfile
	 * @return 
	 * @throws Exception
	 */
	@PutMapping("/updateUserProfile")
	public ResponseEntity<List<UserProfile>> updateUserProfile(@RequestBody UserProfile userProfile) throws Exception {
		
		
		List<UserProfile> userProfilelist = userProfileService.updateUserProfile(userProfile);
		System.out.println("From Rest update user profile : " + userProfilelist);
		
		if(userProfilelist.isEmpty()) {
			
			return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<UserProfile>>(userProfilelist,HttpStatus.OK);		
		
	}
	/**
	 * for deleting user based on userid
	 * @param userid
	 * @return 
	 */
	@DeleteMapping("/deleteUserProfile/{id}")
	public ResponseEntity<List<UserProfile>> deleteUserProfile(@PathVariable("id") int userid) {
		
		List<UserProfile> userProfilelist = userProfileService.deleteUserProfile(userid);
		System.out.println("From Rest delete user: " + userProfilelist);
		
		if(userProfilelist.isEmpty()) {
			
			return new ResponseEntity<List<UserProfile>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserProfile>>(userProfilelist,HttpStatus.OK);		
	}
	/**
	 * For login validation
	 * @param userProfile
	 * @return login userProfile object after  validation
	 * @throws Exception
	 */
	@PostMapping("/login")
	public UserProfile loginUser(@RequestBody UserProfile userProfile) throws Exception {
		String tempEmailId=userProfile.getEmail();
		String tempPassword=userProfile.getPassword();
		UserProfile userObj=null;
		if(tempEmailId!=null && tempPassword!=null) {
			userObj=userProfileService.login(tempEmailId, tempPassword);
		}
		if(userObj==null) {
			throw new Exception("Bad credetianls,User not found");
		}
		return userObj;
		
	}
	/**
	 * for resetting password
	 * @param userProfile
	 * @return UserProfile object if email exist in the database else throws exception
	 * @throws Exception
	 */
	@PutMapping("/resetPassword")
	public UserProfile resetPassword(@RequestBody UserProfile userProfile) throws Exception {
		String tempEmail=userProfile.getEmail();
		String tempPassword=userProfile.getPassword();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			UserProfile userData=userProfileService.findByEmail(tempEmail);
			if(userData==null) {
				throw new Exception("User with email:"+tempEmail+" doesn't exist!");
				
			}
			
		}
		
		userProfileService.resetPassword(tempEmail, tempPassword);
		
		 return userProfile;
		
	}
	@GetMapping("/getUser/{email}")
	public ResponseEntity<UserProfile>getUser(@PathVariable("email") String email) {
		
		UserProfile user = userProfileService.findByEmail(email);
		System.out.println("From Rest allusers : " + user);
		
		if(user==null) {
			
			return new ResponseEntity<UserProfile>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UserProfile>(user,HttpStatus.OK);		
	}
	

}
