package com.lee.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.dao.PayLogDao;
import com.lee.dao.VoucherDao;
import com.lee.pojo.Voucher;
import com.lee.service.VoucherService;
import com.lee.utils.DateUtil;
//@Controller
@RequestMapping("/voucher")
public class voucherController {

	@Resource(name = "voucherService")
	private VoucherService voucherService;
	@Resource(name = "payLogDao")
	private PayLogDao payLogDao;
	@Resource(name = "voucherDao")
	private VoucherDao voucherDao;

	@RequestMapping("/voucherList")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getVoucherDatagrid(HttpServletRequest request) {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String licensePlate = request.getParameter("licensePlate");
		String trailerLicensePate = request.getParameter("trailerLicensePate");
		licensePlate = ("".equals(licensePlate) || licensePlate == null) ? null : licensePlate;
		trailerLicensePate = ("".equals(trailerLicensePate) || trailerLicensePate == null) ? null : trailerLicensePate;
		int currentpage = Integer.parseInt(("0".equals(page) || page == null) ? "1" : page);// 第几页
		int pagesize = Integer.parseInt(("".equals(rows) || rows == null) ? "10" : rows);// 每页多少行
		Map<String, Object> vouchers = this.voucherService.getVoucherDatagrid(currentpage, pagesize, licensePlate,
				trailerLicensePate);
		return vouchers;
	}
	

	
	@RequestMapping("/addVoucher")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int addVoucher(HttpServletRequest request){
		String type= request.getParameter("type");
		String licenseplate= request.getParameter("licenseplate");
		String trailerlicensepate= request.getParameter("trailerlicensepate");
		Date voucherdate= DateUtil.strToUtilDate(request.getParameter("voucherdate"),"yyyy-MM-dd");
		Float sum= Float.parseFloat(request.getParameter("sum"));
		Integer months= Integer.parseInt(request.getParameter("months"));
		Float moneyrate= Float.parseFloat(request.getParameter("moneyrate"));
		String loantype= request.getParameter("loantype");
		String remarks= request.getParameter("remarks");
		Integer truckid= Integer.parseInt(request.getParameter("truckid"));
		
		Voucher v = new Voucher();
		v.setLoantype(loantype);
		v.setMoneyrate(moneyrate);
		v.setMonths(months);
		v.setRemarks(remarks);
		v.setSum(sum);
		v.setType(type);
		v.setVoucherdate(voucherdate);
		v.setTruckid(truckid);
		
		
		int result = this.voucherService.addVoucher(v,licenseplate,trailerlicensepate);
		if(result>0){
			return result;
		}else{
			return 0;
		}
	}
	
	@RequestMapping("/deleteVoucher")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int deleteVoucher(HttpServletRequest request){
		Integer id = Integer.parseInt(request.getParameter("id"),10);
		Integer truckid = this.voucherDao.selectByPrimaryKey(id).getTruckid();
		int r = this.payLogDao.countPayLogByTruckid(truckid);
		if(r>0){
			this.payLogDao.deletePayLogByTruckid(truckid);
		}
		return this.voucherService.deleteVoucher(id);
	}
	
	
	@RequestMapping("/getVoucherByTruckIdAndLoanType")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getVoucherByTruckIdAndLoanType(HttpServletRequest request){
		Integer truckid = Integer.parseInt(request.getParameter("truckid"),10);
		String loanType = request.getParameter("loantype");
		return this.voucherService.getVoucherByTruckIdAndLoanType(truckid, loanType);
	}
	
	
	@RequestMapping("/getContract")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getContract(HttpServletRequest request){
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		int currentpage = Integer.parseInt(("0".equals(page)||page == null) ? "1": page);//第几页
		int pagesize = Integer.parseInt(("".equals(rows)||rows == null) ? "10": rows);//每页多少行
		return this.voucherService.getContract(currentpage,pagesize);
	}
}
