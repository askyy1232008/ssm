package com.lee.dao;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.TempData;

public interface TempDataDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TempData record);

    int insertSelective(TempData record);

    TempData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TempData record);

    int updateByPrimaryKey(TempData record);
    
    int countData(@Param("license") String license,@Param("qryBtm") Timestamp qryBtm,@Param("qryEtm") Timestamp qryEtm);
    
    TempData getTempData(@Param("license") String license,@Param("qryBtm") Timestamp qryBtm,@Param("qryEtm") Timestamp qryEtm);
}