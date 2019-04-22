package com.lee.service;

import java.util.Map;

import com.lee.pojo.User;

public interface UserService {
	/**
	 * 通过id获取单个用户
	 * @param id
	 * @return
	 */
	public User getUserById(int id);
	/**
	 * 登录验证
	 * @param record
	 * @return
	 */
	public User login(User record);
	/**
	 * 用户管理 userList
	 * @return
	 */
	public Map<String,Object> userList();
	/**
	 * 插入用户
	 * @param record
	 * @return
	 */
	public int addUser(User record);
	/**
	 * 修改用户
	 * @param record
	 * @return
	 */
	public int updateUser(User record);
	/**
	 * 删除用户  by id
	 * @param id
	 * @return
	 */
	public int removeUser(int id);
	
	/**
     * 分页查询user  easyui datagrid
     * @param currentpage 第几页
     * @param pagesize 一页多少行
     * @return
     */
	Map<String,Object> getUserDatagrid(int currentpage,int pagesize);
}
