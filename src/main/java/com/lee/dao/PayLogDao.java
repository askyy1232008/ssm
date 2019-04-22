package com.lee.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.PayLog;

public interface PayLogDao {
    int deleteByPrimaryKey(Integer id);

    int insert(PayLog record);

    int insertSelective(PayLog record);

    PayLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PayLog record);

    int updateByPrimaryKey(PayLog record);
    
    List<PayLog> getPayLogDatagrid(@Param("offset") int offset, @Param("limit") int limit,@Param("lp") String licenseplate,
			@Param("tlp") String trailerlicensepate);
    List<PayLog> payLogListForNotShow(@Param("offset") int offset, @Param("limit") int limit,@Param("lp") String licenseplate,
			@Param("tlp") String trailerlicensepate);
    int countPayLog( @Param("lp") String licenseplate,
			@Param("tlp") String trailerlicensepate);
    int countPayLogForNotShow( @Param("lp") String licenseplate,
			@Param("tlp") String trailerlicensepate);
    List<Date> getDatesByid(@Param("tid") int truckid,@Param("vid") int voucherid);
    
    List<PayLog> getPayLogsByidOrderByPayDate(@Param("tid") int truckid,@Param("vid") int voucherid);
    
    PayLog getPayLogByid(@Param("tid") int truckid,@Param("vid") int voucherid,@Param("pd") Date payDate);
    
    Integer hasThisMonthRepayed(@Param("tid") int truckid,@Param("vid") int voucherid,@Param("vd") Date thismonthvoucherdate);
    
    List<PayLog> getNotFinished();
    List<PayLog> getNotFinishedDatagrid(@Param("offset") int offset, @Param("limit") int limit);
    
    Date getLastShowPayLog(@Param("truckid") Integer truckid);
    
    List<PayLog> getPayLogByTruckId(@Param("truckid") Integer truckid);
    
    int deletePayLogByTruckid(@Param("truckid") Integer truckid);
    
    int countPayLogByTruckid(@Param("truckid") Integer truckid);
}