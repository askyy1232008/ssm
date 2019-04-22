package com.lee.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.pojo.PayLog;
import com.lee.service.PayLogService;
import com.lee.utils.DateUtil;

//@Controller
@RequestMapping("/payLog")
public class PayLogController {
	@Resource(name="payLogService")
	private PayLogService payLogService;
	
	
	@RequestMapping("/payLogList")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getpayLogDatagrid(HttpServletRequest request) {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String licensePlate = request.getParameter("licensePlate");
		String trailerLicensePate = request.getParameter("trailerLicensePate");
		licensePlate = ("".equals(licensePlate) || licensePlate == null) ? null : licensePlate;
		trailerLicensePate = ("".equals(trailerLicensePate) || trailerLicensePate == null) ? null : trailerLicensePate;
		int currentpage = Integer.parseInt(("0".equals(page) || page == null) ? "1" : page);// 第几页
		int pagesize = Integer.parseInt(("".equals(rows) || rows == null) ? "10" : rows);// 每页多少行
		return this.payLogService.getpayLogDatagrid(currentpage, pagesize, licensePlate, trailerLicensePate);
	}
	
	@RequestMapping("/addPayLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int addPayLog(@RequestBody PayLog payLog){
		return this.payLogService.addPayLog(payLog);
	}
	
	@RequestMapping("/calculateSum")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object calculateSum(HttpServletRequest request){
		Integer truckid = Integer.parseInt(request.getParameter("truckid"));
		Integer voucherid = Integer.parseInt(request.getParameter("voucherid"));
		Date nowdate = DateUtil.strToUtilDate(request.getParameter("nowdate"), "yyyy-MM-dd") ;
		Date voucherdate =  DateUtil.strToUtilDate(request.getParameter("voucherdate"), "yyyy-MM-dd") ;
		Float allmoney = Float.parseFloat(request.getParameter("allmoney"));
		Integer months = Integer.parseInt(request.getParameter("months"));
		Float moneyrate = Float.parseFloat(request.getParameter("moneyrate"));
		Float repaymentPay = Float.parseFloat(request.getParameter("repaymentPay"));
//		Object result = this.payLogService.calculateSum(truckid, voucherid, nowdate,voucherdate,allmoney,months,moneyrate,licenseplate,trailerlicensepate);
		Object result = this.payLogService.calculateSum(truckid, voucherid, nowdate,voucherdate,allmoney,months,moneyrate,repaymentPay);
		return result;
	}
	
	@RequestMapping("/settlement")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int settlement(HttpServletRequest request){
		Date nowDate = DateUtil.nowDate();
		return this.payLogService.settlement(nowDate);
//		return 1;
	}
	
	@RequestMapping("/checkHasDate")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int checkHasDate(HttpServletRequest request){
		Date settlementDate = DateUtil.strToUtilDate(request.getParameter("settlementDate"), "yyyy-MM-dd");
		return this.payLogService.countSettlementByDate(settlementDate);
	}
	
	
	
	@RequestMapping("/getPayLogByid")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public PayLog getPayLogByid(HttpServletRequest request){
		Integer truckid = Integer.parseInt(request.getParameter("truckid"));
		Integer voucherid = Integer.parseInt(request.getParameter("voucherid"));
		Date paydate = DateUtil.strToUtilDate(request.getParameter("paydate"), "yyyy-MM-dd");
		return this.payLogService.getPayLogByid(truckid, voucherid, paydate);
	}
	
	
	@RequestMapping("/repaymentOverRent")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object repaymentOverRent(HttpServletRequest request){
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String repaymentOverRent = request.getParameter("name");
		int currentpage = Integer.parseInt(("0".equals(page)||page == null) ? "1": page);//第几页
		int pagesize = Integer.parseInt(("".equals(rows)||rows == null) ? "10": rows);//每页多少行
		return this.payLogService.repaymentOverRent(repaymentOverRent,currentpage,pagesize);
	}
	
	@RequestMapping("/payLogListForNotShow")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object payLogListForNotShow(HttpServletRequest request) {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String licensePlate = request.getParameter("licensePlate");
		String trailerLicensePate = request.getParameter("trailerLicensePate");
		licensePlate = ("".equals(licensePlate) || licensePlate == null) ? null : licensePlate;
		trailerLicensePate = ("".equals(trailerLicensePate) || trailerLicensePate == null) ? null : trailerLicensePate;
		int currentpage = Integer.parseInt(("0".equals(page) || page == null) ? "1" : page);// 第几页
		int pagesize = Integer.parseInt(("".equals(rows) || rows == null) ? "10" : rows);// 每页多少行
		return this.payLogService.payLogListForNotShow(currentpage, pagesize, licensePlate, trailerLicensePate);
	}
}
