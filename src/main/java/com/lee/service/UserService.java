package com.lee.service;

import com.lee.pojo.User;

public interface UserService {
	public User getUserById(int id);
	
	public User login(User record);
}
