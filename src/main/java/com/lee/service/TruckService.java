package com.lee.service;

import java.util.Map;

import com.lee.pojo.Truck;

public interface TruckService {

	public boolean addTruck(Truck truck);
	
	public boolean updateTruck(Truck truck);
	
	public Map<String,Object> getTruckDatagrid(int currentpage,int pagesize,Truck t);
	
	public Integer deleteTruck(int id);
	
	public Map<String,Object> earlyWarning(String name,int currentpage, int pagesize);
}
