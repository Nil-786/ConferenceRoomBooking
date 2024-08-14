package com.confRoomBooking.services;

import com.confRoomBooking.models.User;

public interface UserServiceImpl {
	
	int userLogin(String userName, String password);
	int addUser(User user);
	
}
