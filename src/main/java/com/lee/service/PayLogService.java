package com.lee.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.PayLog;


public interface PayLogService {
    public Map<String, Object> getpayLogDatagrid(int currentpage,int pagesize,String lp,String tlp);
    
    public Map<String, Object> payLogListForNotShow(int currentpage,int pagesize,String lp,String tlp);
    
    public int addPayLog(PayLog p);
    
    public Object calculateSum1(Integer truckid,Integer voucherid,Date nowdate,Date voucherdate,Float allmoney,Integer months,Float moneyrate,String licenseplate,String trailerlicensepate);
    
    public Object calculateSum(Integer truckid,Integer voucherid,Date nowdate,Date voucherdate,Float allmoney,Integer months,Float moneyrate,Float repaymentPay);
    
    public PayLog getPayLogByid(Integer truckid,Integer voucherid,Date paydate);
    
    public int settlement(Date d);
    
    public int countSettlementByDate(Date d);
    
    public Map<String,Object> repaymentOverRent(String name,int currentpage, int pagesize);
    
    List<PayLog> getPayLogByTruckId(@Param("truckid") Integer truckid);
    
    int updatePayLog(PayLog p);
}
