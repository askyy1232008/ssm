package com.lee.controller;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lee.dao.DriverDao;
import com.lee.dao.LoanCredentialDao;
import com.lee.dao.LoanLogDao;
import com.lee.dao.PayLogDao;
import com.lee.dao.RepayDao;
import com.lee.dao.TruckDao;
import com.lee.dao.TruckOwnerDao;
import com.lee.dao.VoucherDao;
import com.lee.pojo.Driver;
import com.lee.pojo.PayLog;
import com.lee.pojo.Truck;
import com.lee.pojo.TruckOwner;
import com.lee.service.PayLogService;
import com.lee.service.TruckService;
import com.lee.utils.DateUtil;
import com.lee.utils.ResultBuilder;
import com.lee.utils.StatusCode;

@Controller
@RequestMapping("/truck")
public class TruckController {

	@Resource(name="truckService")
	private TruckService truckService;
	@Resource(name="payLogService")
	private PayLogService payLogService;
	@Resource(name="payLogDao")
	private PayLogDao payLogDao;
	@Resource(name="truckOwnerDao")
	private TruckOwnerDao truckOwnerDao;
	@Resource(name="driverDao")
	private DriverDao driverDao;
	@Resource(name="truckDao")
	private TruckDao truckDao;
	@Resource(name="voucherDao")
	private VoucherDao voucherDao;
	@Resource(name="loanCredentialDao")
	private LoanCredentialDao loanCredentialDao;
	@Resource(name="loanLogDao")
	private LoanLogDao loanLogDao;
	@Resource(name="repayDao")
	private RepayDao repayDao;
	
	@RequestMapping("/editTruck")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object addTruck(HttpServletRequest request) {
		JSONObject jobj = new JSONObject();
		Truck truck = new Truck();
		if((!"".equals(request.getParameter("truckid")))  && request.getParameter("truckid") != null){
			truck.setTruckid(Integer.parseInt(request.getParameter("truckid")));
		}
		truck.setTruckingcompany(request.getParameter("truckingcompany"));
		truck.setLicenseplate(request.getParameter("licenseplate"));
		truck.setDrivinglicense(DateUtil.strToUtilDate(request.getParameter("drivinglicense"), "yyyy-MM-dd"));
		truck.setOperationcertificate(DateUtil.strToUtilDate(request.getParameter("operationcertificate"), "yyyy-MM-dd"));
		truck.setCompulsoryinsurancetime(DateUtil.strToUtilDate(request.getParameter("compulsoryinsurancetime"), "yyyy-MM-dd"));
		truck.setCommercialinsurancetime(DateUtil.strToUtilDate(request.getParameter("commercialinsurancetime"), "yyyy-MM-dd"));
		truck.setVin(request.getParameter("vin"));
		truck.setRecorddate(DateUtil.strToUtilDate(request.getParameter("recorddate"), "yyyy-MM-dd"));
		truck.setRegistrationcertificatenumber(request.getParameter("registrationcertificatenumber"));
		truck.setEnginenumber(request.getParameter("enginenumber"));
		truck.setVehiclebrand(request.getParameter("vehiclebrand"));
		truck.setTrucktype(request.getParameter("trucktype"));
		truck.setVehicletype(request.getParameter("vehicletype"));
		truck.setVehiclecolor(request.getParameter("vehiclecolor"));
		truck.setAppearance(request.getParameter("appearance"));
		truck.setAxlenumber(request.getParameter("axlenumber"));
		truck.setHorsepower(request.getParameter("horsepower"));
		truck.setEnginemodel(request.getParameter("enginemodel"));
		truck.setTotalmass(request.getParameter("totalmass"));
		truck.setAuthenticatedloadquality(request.getParameter("authenticatedloadquality"));
		truck.setCurbweight(request.getParameter("curbweight"));
		truck.setSpeedratio(request.getParameter("speedratio"));
		truck.setCompulsoryinsurcancetypequota(request.getParameter("compulsoryinsurcancetypequota"));
		truck.setCompulsoryinsurcancenumber(request.getParameter("compulsoryinsurcancenumber"));
		truck.setCompulsoryinsurancecompany(request.getParameter("compulsoryinsurancecompany"));
		truck.setCompulsoryinsurancecost(Float.parseFloat(request.getParameter("compulsoryinsurancecost")));
		truck.setCommercialinsurancetypes(request.getParameter("commercialinsurancetypes"));
		truck.setCommercialinsurancenumber(request.getParameter("commercialinsurancenumber"));
		truck.setCommercialinsurancecompany(request.getParameter("commercialinsurancecompany"));
		truck.setCommercialinsurancecost(Float.parseFloat(request.getParameter("commercialinsurancecost")));
		truck.setTyre(request.getParameter("tyre"));
		truck.setTrailerlicensepate(request.getParameter("trailerlicensepate"));
		truck.setGdrivinglicense(DateUtil.strToUtilDate(request.getParameter("gdrivinglicense"), "yyyy-MM-dd"));
		truck.setGoperationcertificate(DateUtil.strToUtilDate(request.getParameter("goperationcertificate"), "yyyy-MM-dd"));
		truck.setGcommercialinsurancedate(DateUtil.strToUtilDate(request.getParameter("gcommercialinsurancedate"), "yyyy-MM-dd"));
		truck.setGvin(request.getParameter("gvin"));
		truck.setGrecorddate(DateUtil.strToUtilDate(request.getParameter("grecorddate"), "yyyy-MM-dd"));
		truck.setGregistrationcertificatenumber(request.getParameter("gregistrationcertificatenumber"));
		truck.setGvehiclebrand(request.getParameter("gvehiclebrand"));
		truck.setGtrucktype(request.getParameter("gtrucktype"));
		truck.setGvehicletype(request.getParameter("gvehicletype"));
		truck.setGvehiclecolor(request.getParameter("gvehiclecolor"));
		truck.setGauthenticatedloadquality(request.getParameter("gauthenticatedloadquality"));
		truck.setGcurbweight(request.getParameter("gcurbweight"));
		truck.setGtotalmass(request.getParameter("gtotalmass"));
		truck.setGrearaxle(request.getParameter("grearaxle"));
		truck.setGappearance(request.getParameter("gappearance"));
		truck.setGcontainersize(request.getParameter("gcontainersize"));
		truck.setGtyre(request.getParameter("gtyre"));
		truck.setGsparetire(request.getParameter("gsparetire"));
		truck.setGcommercialinsurancetypequota(request.getParameter("gcommercialinsurancetypequota"));
		truck.setGcommercialinsurancenumber(request.getParameter("gcommercialinsurancenumber"));
		truck.setGcommercialinsurancecompany(request.getParameter("gcommercialinsurancecompany"));
		truck.setGcommercialinsurancecost(request.getParameter("gcommercialinsurancecost"));
		
		TruckOwner truckOwner = new TruckOwner();
		truckOwner.setAdress(request.getParameter("adress"));
		String issingle = request.getParameter("issingle");
		truckOwner.setIssingle(issingle);
		truckOwner.setName(request.getParameter("name"));
		truckOwner.setNumber(request.getParameter("number"));
		truckOwner.setPhone(request.getParameter("phone"));
		
		Driver driver = new Driver();
		driver.setDriveraddress(request.getParameter("driveraddress"));
		driver.setDriveridcard(request.getParameter("driveridcard"));
		driver.setDrivername(request.getParameter("drivername"));
		driver.setDriverphone(request.getParameter("driverphone"));
		
		boolean flag = false;
		String truckStr = JSONObject.toJSONString(truck);
		int value = truckStr.indexOf("truckid");
		if(value != -1){
			flag = true;
		}
		if(flag){
			this.truckService.updateTruck(truck);
			truckOwner.setTruckid(truck.getTruckid());
			driver.setTruckid(truck.getTruckid());
			String licenseplate = truck.getLicenseplate();
			String trailerlicensepate = truck.getTrailerlicensepate();
			Integer truckid = truck.getTruckid();
			List<PayLog> pls = this.payLogService.getPayLogByTruckId(truckid);
			for(PayLog p:pls){
				p.setLicenseplate(licenseplate);
				p.setTrailerlicensepate(trailerlicensepate);
				this.payLogService.updatePayLog(p);
			}
			truckOwner.setId(Integer.parseInt(request.getParameter("truckOwnerid")));
			driver.setId(Integer.parseInt(request.getParameter("driverid")));
			this.truckOwnerDao.updateByPrimaryKey(truckOwner);
			this.driverDao.updateByPrimaryKey(driver);
			jobj.put("action", "update");
		}else{
			Boolean b = this.truckService.addTruck(truck);
			Truck t = this.truckDao.getTheLastTruck();
			truckOwner.setTruckid(t.getTruckid());
			driver.setTruckid(t.getTruckid());
			this.truckOwnerDao.insertSelective(truckOwner);
			this.driverDao.insertSelective(driver);
			jobj.put("action", "add");
			if(!b){
				ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.FALL);
				return resultBuilder;
			}
		}
		ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
		return resultBuilder;
	}
	
	@RequestMapping("/truckList")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getTruckDatagrid(HttpServletRequest request) {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String truckingCompany = request.getParameter("truckingCompany");
		String licensePlate = request.getParameter("licensePlate");
		String trailerLicensePate = request.getParameter("trailerLicensePate");
		Truck t = new Truck();
		t.setTruckingcompany(("".equals(truckingCompany)||truckingCompany == null)? null:truckingCompany);
		t.setLicenseplate(("".equals(licensePlate)||licensePlate == null)? null:licensePlate);
		t.setTrailerlicensepate(("".equals(trailerLicensePate)||trailerLicensePate == null)? null:trailerLicensePate);
		int currentpage = Integer.parseInt(("0".equals(page)||page == null) ? "1": page);//第几页
		int pagesize = Integer.parseInt(("".equals(rows)||rows == null) ? "10": rows);//每页多少行
		Map<String, Object> trucks = this.truckService.getTruckDatagrid(currentpage,pagesize,t);
		return trucks;
	}
	
	@RequestMapping("/deleteTruck")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int deleteTruck(HttpServletRequest request){
		Integer id = Integer.parseInt(request.getParameter("truckid"),10);
		int result = this.truckService.deleteTruck(id);
		int r4 = this.voucherDao.countVoucherByTruckid(id);
		if(r4>0){
			this.voucherDao.deleteVoucherByTruckid(id);
			this.payLogDao.deletePayLogByTruckid(id);
		}
		int r3 = this.truckOwnerDao.countTruckOwnerByTruckid(id);
		if(r3>0){
			this.truckOwnerDao.deleteTruckOwnerByTruckid(id);
		}
		int r1 = this.driverDao.countDriverByTurckid(id);
		if(r1>0){
			this.driverDao.deleteDriverByTurckid(id);
		}
		int r5 = this.repayDao.countByTruckid(id);
		if(r5>0){
			this.repayDao.deleteByTruckid(id);
		}
		int r6 = this.loanCredentialDao.countByTruckid(id);
		if(r6>0){
			this.loanCredentialDao.deleteByTruckid(id);
			this.loanLogDao.deleteByTruckid(id);
		}
		if(result>0){
			return result;
		}else{
			return 0;
		}
	}
	
	@RequestMapping("/getTruck")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getTruck(HttpServletRequest request){
		int truckid = Integer.parseInt(request.getParameter("truckid"));
		Truck t = this.truckDao.selectByPrimaryKey(truckid);
		TruckOwner truckOwner = this.truckOwnerDao.getTruckOwnerByTruckid(truckid).get(0);
		Driver driver = this.driverDao.getDriverByTruckid(truckid);
		JSONObject jobj = new JSONObject();
		jobj.put("truck", t);
		jobj.put("truckOwner",truckOwner);
		jobj.put("driver", driver);
		jobj.put("driverid",driver.getId());
		jobj.put("truckOwnerid",truckOwner.getId());
		ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
		return resultBuilder;
	}
	
	
	@RequestMapping("/earlyWarning")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object earlyWarning(HttpServletRequest request){
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		String date = request.getParameter("name");
		int currentpage = Integer.parseInt(("0".equals(page)||page == null) ? "1": page);//第几页
		int pagesize = Integer.parseInt(("".equals(rows)||rows == null) ? "10": rows);//每页多少行
		return this.truckService.earlyWarning(date,currentpage,pagesize);
	}
	
}
