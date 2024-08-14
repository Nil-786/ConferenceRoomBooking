package com.confRoomBooking.services;

import com.confRoomBooking.models.User;
import com.confRoomBooking.repositories.UserRepo;
import com.confRoomBooking.repositories.UserRepoImpl;

public class userService implements UserServiceImpl{
	
	UserRepoImpl userRepo = new UserRepo();
	
	@Override
	public int userLogin(String userName, String password) {
		int id = userRepo.readUserByUserNamePassword(userName, password).getId();
		return id;
	}

	@Override
	public int addUser(User user) {
		return userRepo.addUser(user);
	}

}
