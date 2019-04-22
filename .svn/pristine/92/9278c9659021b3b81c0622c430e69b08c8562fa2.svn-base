package com.lee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.Repay;

public interface RepayDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Repay record);

    int insertSelective(Repay record);

    Repay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Repay record);

    int updateByPrimaryKey(Repay record);
    
    Repay getthistrucklast(@Param("truckid") int truckid);
    
    List<Repay> getthistruckall(@Param("truckid") int truckid);
    
    int countthistruckall(@Param("truckid") int truckid);
    
    int getthistrucklastid(@Param("truckid") int truckid);
    
	int countByTruckid(@Param("truckid") int truckid);
	
	int deleteByTruckid(@Param("truckid") int truckid);
    
}