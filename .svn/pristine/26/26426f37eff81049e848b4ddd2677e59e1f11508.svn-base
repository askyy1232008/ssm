package com.lee.dao;

import com.lee.pojo.Driver;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DriverDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Driver record);

    int insertSelective(Driver record);

    Driver selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Driver record);

    int updateByPrimaryKey(Driver record);
    
    Driver getDriverByTruckid(@Param("truckid") int truckid);
    
    List<Driver> getDrivers();
   
    Driver getDriverByIdCard(@Param("idcard") String idcard);
    
    int deleteDriverByTurckid(@Param("truckid") int truckid);
    
    int countDriverByTurckid(@Param("truckid") int truckid);
}