package com.lee.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.Settlement;

public interface SettlementDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Settlement record);

    int insertSelective(Settlement record);

    Settlement selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Settlement record);

    int updateByPrimaryKey(Settlement record);
    
    int count(@Param("settlementDate") Date settlementDate);
}