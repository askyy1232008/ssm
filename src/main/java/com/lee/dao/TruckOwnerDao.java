package com.lee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.TruckOwner;

public interface TruckOwnerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TruckOwner record);

    int insertSelective(TruckOwner record);

    TruckOwner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TruckOwner record);

    int updateByPrimaryKey(TruckOwner record);
    
    List<TruckOwner> getTruckOwnerByTruckid(@Param("truckid") Integer truckid);
    
    List<TruckOwner> getTruckOwnerIsNotsigle();
    
    TruckOwner getTruckOwnerByIdCard(@Param("idcard") String idcard);
    
    int deleteTruckOwnerByTruckid(@Param("truckid") Integer truckid);
    
    int countTruckOwnerByTruckid(@Param("truckid") Integer truckid);
}