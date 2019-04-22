package com.lee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.LoanCredential;

public interface LoanCredentialDao {
	int deleteByPrimaryKey(Integer id);

	int insert(LoanCredential record);

	int insertSelective(LoanCredential record);

	LoanCredential selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(LoanCredential record);

	int updateByPrimaryKey(LoanCredential record);

	List<LoanCredential> getLoanCredentialDatagrid(@Param("offset") int offset, @Param("limit") int limit,
			@Param("licenseplate") String licenseplate, @Param("trailerlicensepate") String trailerlicensepate,
			@Param("financecompany") String financecompany,@Param("loanpeople") String loanpeople);

	int countGetLoanCredentialDatagrid(@Param("licenseplate") String licenseplate,@Param("trailerlicensepate") String trailerlicensepate,
			@Param("financecompany") String financecompany, @Param("loanpeople") String loanpeople);

	int countByTruckidAndVin(@Param("truckid") int truckid,@Param("vin") String vin,@Param("type") String type);
	
	int countByTruckid(@Param("truckid") int truckid);
	
	int deleteByTruckid(@Param("truckid") int truckid);
}