package com.lee.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.dao.UserDao;
import com.lee.pojo.User;
import com.lee.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	public User getUserById(int id) {
		return this.userDao.selectByPrimaryKey(id);
	}

	public User login(User record) {
		User u = this.userDao.countUserForLogin(record);
		if(u != null){
			return u;
		}else{
			return null;
		}
	}
}
