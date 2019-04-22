package com.lee.controller;

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
import com.lee.dao.DriverDao;
import com.lee.dao.TruckOwnerDao;
import com.lee.pojo.Driver;
import com.lee.pojo.TruckOwner;
import com.lee.service.TruckOwnerService;
import com.lee.utils.ResultBuilder;
import com.lee.utils.StatusCode;

@Controller
@RequestMapping("/truckOwner")
public class TruckOwnerController {
	
	@Resource(name = "truckOwnerService")
	private TruckOwnerService truckOwnerService;
	@Resource(name="truckOwnerDao")
	private TruckOwnerDao truckOwnerDao;
	@Resource(name="driverDao")
	private DriverDao driverDao;
	
	@RequestMapping("/getTruckOwner")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getTruckOwner(HttpServletRequest request){
		Integer truckid = Integer.parseInt(request.getParameter("truckid"));
		return this.truckOwnerService.getTruckOwner(truckid);
	}
	
	@RequestMapping("/addTruckOwner")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int addTruckOwner(@RequestBody TruckOwner to){
		return this.truckOwnerService.addTruckOwner(to);
	}
	
	@RequestMapping("/updateTruckOwner")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int updateTruckOwner(@RequestBody TruckOwner to){
		return this.truckOwnerService.updateTruckOwner(to);
	}
	
	@RequestMapping("/getTruckOwnerAndDriverByIdCard")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getTruckOwnerAndDriverByIdCard(HttpServletRequest request){
		String action = request.getParameter("action");
		String truckid = request.getParameter("truckid");
		if("truckOwner".equals(action)){
			Integer truckOwnerid = Integer.parseInt(request.getParameter("id"));
			TruckOwner truckOwner = this.truckOwnerDao.selectByPrimaryKey(truckOwnerid);
//			TruckOwner truckOwner = this.truckOwnerDao.getTruckOwnerByIdCard(idCard);
			if("".equals(truckid)){
				truckOwner.setTruckid(null);
			}else{
				truckOwner.setTruckid(Integer.parseInt(truckid));
			}
			JSONObject jobj = new JSONObject();
			jobj.put("truckOwner", truckOwner);
			ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
			return resultBuilder;
		}
		if("driver".equals(action)){
			Integer driverid = Integer.parseInt(request.getParameter("id"));
			Driver driver = this.driverDao.selectByPrimaryKey(driverid);
//			Driver driver = this.driverDao.getDriverByIdCard(idCard);
			if("".equals(truckid)){
				driver.setTruckid(null);
			}else{
				driver.setTruckid(Integer.parseInt(truckid));
			}
			JSONObject jobj = new JSONObject();
			jobj.put("driver", driver);
			ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
			return resultBuilder;
		}
		return null;
	}
	
	
	@RequestMapping("/getTruckOwnerAndDriver")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getTruckOwnerAndDriver(HttpServletRequest request){
		List<Map<String,Object>> list1 = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list2 = new ArrayList<Map<String,Object>>();
		List<TruckOwner> TruckOwner = this.truckOwnerDao.getTruckOwnerIsNotsigle();
		List<Driver> driver = this.driverDao.getDrivers();
		for(TruckOwner to:TruckOwner){
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("id", to.getId());
			m.put("text", to.getName());
			list1.add(m);
		}
		for(Driver d:driver){
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("id", d.getId());
			m.put("text", d.getDrivername());
			list2.add(m);
		}
		JSONObject jobj = new JSONObject();
		jobj.put("truckOwner", list1);
		jobj.put("driver", list2);
		ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
		return resultBuilder;
	}
	
	
}
