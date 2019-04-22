package com.lee.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lee.dao.LoanCredentialDao;
import com.lee.dao.LoanLogDao;
import com.lee.dao.TruckDao;
import com.lee.pojo.LoanCredential;
import com.lee.pojo.LoanLog;
import com.lee.pojo.Truck;
import com.lee.utils.BeanUtil;
import com.lee.utils.DateUtil;
import com.lee.utils.ResultBuilder;
import com.lee.utils.StatusCode;

@Controller
@RequestMapping("/loan")
public class LoanController {
	@Resource(name = "loanCredentialDao")
	private LoanCredentialDao loanCredentialDao;
	@Resource(name = "loanLogDao")
	private LoanLogDao loanLogDao;
	@Resource(name = "truckDao")
	private TruckDao truckDao;

	@RequestMapping("/loanList")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object loanList(HttpServletRequest request) {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String licensePlate = request.getParameter("licensePlate");
		String trailerlicensepate = request.getParameter("trailerlicensepate");
		String financecompany = request.getParameter("financecompany");
		String loanpeople = request.getParameter("loanpeople");
		licensePlate = ("".equals(licensePlate) || licensePlate == null) ? null : licensePlate;
		trailerlicensepate = ("".equals(trailerlicensepate) || trailerlicensepate == null) ? null : trailerlicensepate;
		financecompany = ("".equals(financecompany) || financecompany == null) ? null : financecompany;
		loanpeople = ("".equals(loanpeople) || loanpeople == null) ? null : loanpeople;
		int currentpage = Integer.parseInt(("0".equals(page) || page == null) ? "1" : page);// 第几页
		int pagesize = Integer.parseInt(("".equals(rows) || rows == null) ? "10" : rows);// 每页多少行
		List<LoanCredential> list = this.loanCredentialDao.getLoanCredentialDatagrid((currentpage - 1) * pagesize,
				pagesize, licensePlate, trailerlicensepate,financecompany, loanpeople);
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < list.size(); i++) {
			Integer loanid = list.get(i).getId();
			Integer truckid = list.get(i).getTruckid();
			Map<String, Object> m = BeanUtil.transBean2Map(list.get(i));
			LoanLog lastLoanLog = loanLogDao.getLoanLogByLoanidOrderByIdLimitOne(loanid);
			if(lastLoanLog != null) {
				m.put("lastpayeddate",DateUtil.dateToStr(lastLoanLog.getPayeddate(), "yyyy-MM-dd"));
				m.put("thismonthpayed",Double.parseDouble(lastLoanLog.getThatmonthhasreturned().toString())+Double.parseDouble(lastLoanLog.getNowpay().toString()));
			}else {
				m.put("lastpayeddate","0000-00-00");
				m.put("thismonthpayed",null);
			}
			Truck t = truckDao.selectByPrimaryKey(truckid);
			m.put("licenseplate", t.getLicenseplate());
			m.put("trailerlicensepate", t.getTrailerlicensepate());
			list1.add(m);
		}
		int total = this.loanCredentialDao.countGetLoanCredentialDatagrid(licensePlate,trailerlicensepate, financecompany, loanpeople);
		Map<String, Object> newMap = new HashMap<String, Object>();
		newMap.put("total", total);
		newMap.put("rows", list1);
		return newMap;
	}

	@RequestMapping("/addLoan")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int addLoan(@RequestBody LoanCredential lc) {
		Integer truckid = lc.getTruckid();
		String vin = lc.getVin();
		String type = lc.getType();
		int r2 = this.loanCredentialDao.countByTruckidAndVin(truckid,vin,"主挂车");
		if(r2>0) {
			return 0;
		}
		int r3 = this.loanCredentialDao.countByTruckidAndVin(truckid,vin,type);
		if (r3 > 0) {
			return 0;
		}
		int r1 = this.loanCredentialDao.insertSelective(lc);
		if (r1 > 0) {
			return 1;
		} else {
			return 2;
		}
	}

	@RequestMapping("/deleteLoan")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int deleteLoan(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		int r1 = this.loanCredentialDao.deleteByPrimaryKey(id);
		int r2 = this.loanLogDao.countByLoanid(id);
		if (r2 > 0) {
			this.loanLogDao.deleteByLoanid(id);
		}
		if (r1 > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@RequestMapping("/getLastLoanLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getLastLoanLog(HttpServletRequest request) {
		Integer loanid = Integer.parseInt(request.getParameter("loanid"));
		LoanLog lastLoanLog = loanLogDao.getLoanLogByLoanidOrderByIdLimitOne(loanid);
		JSONObject jobj = new JSONObject();
		ResultBuilder<JSONObject> resultBuilder;
		jobj.put("result", lastLoanLog);
		resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
		return resultBuilder;
	}
	
	@RequestMapping("/addLoanLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int addLoanLog(@RequestBody LoanLog loanlog) {
		int r = loanLogDao.insertSelective(loanlog);
		if(r>0) {
			return 1;
		}else {
			return 0;
		}
	}
	
	@RequestMapping("/deleteLoanLog")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object deleteLoanLog(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		int loanid = Integer.parseInt(request.getParameter("loanid"));
		JSONObject jobj = new JSONObject();
		int lastid = loanLogDao.getThatLastLoanLogIdByLoanid(loanid);
		if(id == lastid){
			int r = loanLogDao.deleteByPrimaryKey(id);
			if(r>0){
				jobj.put("r", "删除成功!");
				ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
				return resultBuilder;
			}else{
				jobj.put("r", "删除失败,没有删除任何一条记录!");
				ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.FALL);
				return resultBuilder;
			}
		}else{
			jobj.put("r", "删除失败,不是最后一条记录!");
			ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.FALL);
			return resultBuilder;
		}
	}
	
	
	@RequestMapping("/getThisLoanAll")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getThisLoanAll(HttpServletRequest request) {
		Integer loanid = Integer.parseInt(request.getParameter("loanid"));
		List<LoanLog> loanLogs = loanLogDao.getThisLoanAll(loanid);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for(LoanLog ll :loanLogs) {
			Map<String,Object> map = BeanUtil.transBean2Map(ll);
			map.replace("payeddate", sdf.format(map.get("payeddate")));
			double accumulatedrepayment = Double.parseDouble(map.get("accumulatedrepayment").toString())+Double.parseDouble(map.get("nowpay").toString());
			map.replace("accumulatedrepayment",accumulatedrepayment);
			double thatmonthhasreturned = Double.parseDouble(map.get("thatmonthhasreturned").toString())+Double.parseDouble(map.get("nowpay").toString());
			map.replace("thatmonthhasreturned",thatmonthhasreturned);
			double surplusshouldalsobereturned = Double.parseDouble(map.get("totalrepayment").toString())-Double.parseDouble(map.get("accumulatedrepayment").toString());
			map.replace("surplusshouldalsobereturned",surplusshouldalsobereturned);
			list.add(map);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		int total = loanLogDao.countThisLoanAll(loanid);
		map.put("total",total);
		map.put("rows",list);
		return map;
	}
	
}
