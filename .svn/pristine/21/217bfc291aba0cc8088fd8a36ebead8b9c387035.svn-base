package com.lee.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.Voucher;

public interface VoucherDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Voucher record);

    int insertSelective(Voucher record);

    Voucher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Voucher record);

    int updateByPrimaryKey(Voucher record);
    
    List<Map<String, Object>> getVoucherDatagrid(@Param("offset") int offset, @Param("limit") int limit,@Param("lp") String lp,@Param("tlp") String tlp);
    
    int countVoucher(@Param("lp") String lp,@Param("tlp") String tlp);
    
    int countVoucherByTruckIdAndLoanType(@Param("truckid") int truckid,@Param("lt") String loanType);
    
    Voucher getVoucherByTruckIdAndLoanType(@Param("truckid") int truckid,@Param("lt") String loanType);
    
    Integer getLastVoucher();
    
    List<Voucher> getVouchers(@Param("offset") int offset, @Param("limit") int limit);
    
    int deleteVoucherByTruckid(@Param("truckid") int truckid);
    
    int countVoucherByTruckid(@Param("truckid") int truckid);
}