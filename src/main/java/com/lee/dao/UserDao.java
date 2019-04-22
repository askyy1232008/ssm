package com.lee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.User;

public interface UserDao {
	/**
	 * 通过id删除user
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
    /**
     * 新增一个user
     * @param record
     * @return
     */
    int insert(User record);
    /**
     * 新增一个user
     * @param record
     * @return
     */
    int insertSelective(User record);
    /**
     * 通过id查询user
     * @param id
     * @return
     */
    User selectByPrimaryKey(Integer id);
    /**
     * 更新一个user
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);
    /**
     * 更新一个user
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);
    /**
     * 用于登录
     * @param record
     * @return
     */
    User login(User record);
    /**
     * 获取全部用户
     * @return
     */
    List<User> getAllUser();
    /**
     * 分页查询user  easyui datagrid
     * @param offset 
     * @param limit 
     * @return
     */
    List<User> getUserDatagrid(@Param("offset") int offset,@Param("limit") int limit);
    
    Integer countUserByUserName(@Param("userName") String userName);
}