package com.confRoomBooking.services;

import com.confRoomBooking.models.User;
import com.confRoomBooking.repositories.UserRepo;
import com.confRoomBooking.repositories.UserRepoImpl;

public class userService implements UserServiceImpl{
	
	UserRepoImpl userRepo = new UserRepo();
	
	@Override
	public User userLogin(String userName, String password) {
		User user = userRepo.readUserByUserNamePassword(userName, password);
		return user;
	}

	@Override
	public int addUser(User user) {
		return userRepo.addUser(user);
	}

}
