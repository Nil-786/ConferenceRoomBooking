package com.confRoomBooking.repositories;

import java.util.List;

import com.confRoomBooking.models.User;

public interface UserRepoImpl {
	public int addUser(User user) ;
	public User readUserByUserNamePassword(String userName, String passWord);
	public User readUser(int id);
	public List<User> readAllUser();
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
}
