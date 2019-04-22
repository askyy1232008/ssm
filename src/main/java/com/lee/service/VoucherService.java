package com.lee.service;

import java.util.Map;

import com.lee.pojo.Voucher;


public interface VoucherService {
	public Map<String,Object> getVoucherDatagrid(int currentpage,int pagesize,String lp,String tlp);
	
	public int addVoucher(Voucher v,String lp,String tlp);
	
	public int deleteVoucher(Integer id);
	
	public Voucher getVoucherByTruckIdAndLoanType(Integer truckid,String loanType);
	
	public Map<String,Object> getContract(Integer currentpage,Integer pagesize);
}
