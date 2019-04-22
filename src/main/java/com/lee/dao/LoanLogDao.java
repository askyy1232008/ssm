package com.lee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.LoanLog;

public interface LoanLogDao {
	int deleteByPrimaryKey(Integer id);

	int insert(LoanLog record);

	int insertSelective(LoanLog record);

	LoanLog selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(LoanLog record);

	int updateByPrimaryKey(LoanLog record);

	int deleteByLoanid(@Param("loanid") Integer loanid);

	int countByLoanid(@Param("loanid") Integer loanid);

	LoanLog getLoanLogByLoanidOrderByIdLimitOne(@Param("loanid") Integer loanid);
	
	List<LoanLog> getThisLoanAll(@Param("loanid") Integer loanid);
	
	int countThisLoanAll(@Param("loanid") Integer loanid);
	
	int getThatLastLoanLogIdByLoanid(@Param("loanid") Integer loanid);
	
	int countByTruckid(@Param("truckid") int truckid);
	
	int deleteByTruckid(@Param("truckid") int truckid);
}