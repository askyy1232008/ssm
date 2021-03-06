package com.lee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		User u = this.userDao.login(record);
		if (u != null) {
			return u;
		} else {
			return null;
		}
	}

	public Map<String,Object> userList() {
		List<User> users = this.userDao.getAllUser();
		int total = users.size();
		Map<String,Object> userList = new HashMap<String,Object>();
		userList.put("total",total);
		userList.put("rows",users);
		return userList;
	}

	@Override
	public int addUser(User record) {
		// TODO Auto-generated method stub
		String userName = record.getUserName();
		Integer checkUserName = this.userDao.countUserByUserName(userName);
		if(checkUserName>0){
			return 0;
		}
		return this.userDao.insertSelective(record);
	}

	@Override
	public int updateUser(User record) {
		// TODO Auto-generated method stub
		return this.userDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int removeUser(int id) {
		// TODO Auto-generated method stub
		return this.userDao.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String,Object> getUserDatagrid(int currentpage,int pagesize) {
		// TODO Auto-generated method stub
		List<User> users = this.userDao.getUserDatagrid((currentpage-1)*pagesize,pagesize);
		int total = this.userDao.getAllUser().size();
		Map<String,Object> userList = new HashMap<String,Object>();
		userList.put("total",total);
		userList.put("rows",users);
		return userList;
	}
}
