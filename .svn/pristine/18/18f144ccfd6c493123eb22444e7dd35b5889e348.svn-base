package com.lee.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.dao.TruckDao;
import com.lee.pojo.Truck;
import com.lee.pojo.TruckOwner;
import com.lee.service.TruckService;
import com.lee.utils.BeanUtil;
import com.lee.utils.DateUtil;

@Service("truckService")
public class TruckServiceImpl implements TruckService {

	@Resource
	private TruckDao truckDao;

	@Override
	public boolean addTruck(Truck truck) {
		// TODO Auto-generated method stub
		String licenseplate = truck.getLicenseplate();
		String trailerlicensepate = truck.getTrailerlicensepate();
		licenseplate = ("".equals(licenseplate)||licenseplate == null)? null:licenseplate;
		trailerlicensepate = ("".equals(trailerlicensepate)||trailerlicensepate == null)? null:trailerlicensepate;
		Integer coutTruck = this.truckDao.countTruckByLPAndTL(licenseplate,trailerlicensepate);
		if(coutTruck>0){
			return false;
		}
		int result = this.truckDao.insert(truck);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateTruck(Truck truck) {
		// TODO Auto-generated method stub
		int result = this.truckDao.updateByPrimaryKey(truck);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, Object> getTruckDatagrid(int currentpage, int pagesize, Truck t) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> Trucks = this.truckDao.getTruckDatagrid((currentpage - 1) * pagesize, pagesize,
				t.getTruckingcompany(), t.getLicenseplate(), t.getTrailerlicensepate());
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(int i=0;i<Trucks.size();i++){
			Map<String,Object> map = BeanUtil.transBean2Map(Trucks.get(i));
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("vin", map.get("vin"));
			m.put("compulsoryinsurcancetypequota",map.get("compulsoryinsurcancetypequota"));
			m.put("commercialinsurancetime", map.get("commercialinsurancetime"));
			m.put("compulsoryinsurancetime", map.get("compulsoryinsurancetime"));
			m.put("drivinglicense", map.get("drivinglicense"));
			m.put("gcommercialinsurancedate", map.get("gcommercialinsurancedate"));
			m.put("gdrivinglicense", map.get("gdrivinglicense"));
			m.put("goperationcertificate", map.get("goperationcertificate"));
			m.put("licenseplate", map.get("licenseplate"));
			m.put("operationcertificate", map.get("operationcertificate"));
			m.put("trailerlicensepate", map.get("trailerlicensepate"));
			m.put("truckid", map.get("truckid"));
			m.put("truckingcompany", map.get("truckingcompany"));
			m.put("name", ((TruckOwner)map.get("truckOwner")).getName());
			m.put("phone", ((TruckOwner)map.get("truckOwner")).getPhone());
			list.add(m);
		}
		Collections.sort(list,new Comparator<Map<String, Object>>(){
			@Override
			public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
				// TODO Auto-generated method stub
				String compulsoryinsurcancetypequota1 = arg0.get("compulsoryinsurcancetypequota").toString();
				String compulsoryinsurcancetypequota2 = arg1.get("compulsoryinsurcancetypequota").toString();
				String[] str1 = compulsoryinsurcancetypequota1.split("/");
				String[] str2 = compulsoryinsurcancetypequota2.split("/");
				Integer name1 = Integer.valueOf(str1[0])*12+Integer.valueOf(str1[1])*30+Integer.valueOf(str1[2]);
                Integer name2 = Integer.valueOf(str2[0])*12+Integer.valueOf(str2[1])*30+Integer.valueOf(str2[2]);
                return name1.compareTo(name2);
			}
		});
		int total = this.truckDao.countTrucks(t.getTruckingcompany(), t.getLicenseplate(), t.getTrailerlicensepate());
		Map<String, Object> TruckList = new HashMap<String, Object>();
		TruckList.put("total", total);
		TruckList.put("rows", list);
		return TruckList;
	}

	@Override
	public Integer deleteTruck(int id) {
		// TODO Auto-generated method stub
		return this.truckDao.deleteByPrimaryKey(id);
	}

	@Override
	public Map<String,Object> earlyWarning(String name,int currentpage, int pagesize) {
		// TODO Auto-generated method stub
		List<Truck> trucks= this.truckDao.getTrucks(name,(currentpage - 1) * pagesize, pagesize);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		int len = trucks.size();
		Date nowDate = DateUtil.nowDate();
		for(int i=0;i<len;i++){
			Truck t = trucks.get(i);
			try {
				if("compulsoryInsuranceTime".equals(name)){
					Map<String,Object> m = new HashMap<String,Object>();
					m.put("licensePlate", t.getLicenseplate());
					m.put("trailerLicensePate", t.getTrailerlicensepate());
					m.put("compulsoryInsuranceTime", t.getCompulsoryinsurancetime());
					m.put("compulsoryInsuranceTimeDays",DateUtil.daysBetween(nowDate, t.getCompulsoryinsurancetime()));
					list.add(m);
					Collections.sort(list,new Comparator<Map<String, Object>>(){
						@Override
						public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
							// TODO Auto-generated method stub
							Integer name1 = Integer.valueOf(arg0.get("compulsoryInsuranceTimeDays").toString()) ;//name1是从你list里面拿出来的一个 
			                Integer name2 = Integer.valueOf(arg1.get("compulsoryInsuranceTimeDays").toString()) ; //name1是从你list里面拿出来的第二个name
			                return name1.compareTo(name2);
						}
					});
				}
				if("commercialInsuranceTime".equals(name)){
					Map<String,Object> m = new HashMap<String,Object>();
					m.put("licensePlate", t.getLicenseplate());
					m.put("trailerLicensePate", t.getTrailerlicensepate());
					m.put("commercialInsuranceTime", t.getCommercialinsurancetime());
					m.put("commercialInsuranceTimeDays",DateUtil.daysBetween(nowDate, t.getCommercialinsurancetime()));
					list.add(m);
					Collections.sort(list,new Comparator<Map<String, Object>>(){
						@Override
						public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
							// TODO Auto-generated method stub
							Integer name1 = Integer.valueOf(arg0.get("commercialInsuranceTimeDays").toString()) ;//name1是从你list里面拿出来的一个 
			                Integer name2 = Integer.valueOf(arg1.get("commercialInsuranceTimeDays").toString()) ; //name1是从你list里面拿出来的第二个name
			                return name1.compareTo(name2);
						}
					});
				}
				if("drivingLicense".equals(name)){
					Map<String,Object> m = new HashMap<String,Object>();
					m.put("licensePlate", t.getLicenseplate());
					m.put("trailerLicensePate", t.getTrailerlicensepate());
					m.put("drivingLicenseTime", t.getDrivinglicense());
					m.put("drivingLicenseTimeDays",DateUtil.daysBetween(nowDate, t.getDrivinglicense()));
					list.add(m);
					Collections.sort(list,new Comparator<Map<String, Object>>(){
						@Override
						public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
							// TODO Auto-generated method stub
							Integer name1 = Integer.valueOf(arg0.get("drivingLicenseTimeDays").toString()) ;//name1是从你list里面拿出来的一个 
			                Integer name2 = Integer.valueOf(arg1.get("drivingLicenseTimeDays").toString()) ; //name1是从你list里面拿出来的第二个name
			                return name1.compareTo(name2);
						}
					});
				}
				if("operationCertificate".equals(name)){
					Map<String,Object> m = new HashMap<String,Object>();
					m.put("licensePlate", t.getLicenseplate());
					m.put("trailerLicensePate", t.getTrailerlicensepate());
					m.put("operationCertificateTime", t.getOperationcertificate());
					m.put("operationCertificateTimeDays",DateUtil.daysBetween(nowDate, t.getOperationcertificate()));
					list.add(m);
					Collections.sort(list,new Comparator<Map<String, Object>>(){
						@Override
						public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
							// TODO Auto-generated method stub
							Integer name1 = Integer.valueOf(arg0.get("operationCertificateTimeDays").toString()) ;//name1是从你list里面拿出来的一个 
			                Integer name2 = Integer.valueOf(arg1.get("operationCertificateTimeDays").toString()) ; //name1是从你list里面拿出来的第二个name
			                return name1.compareTo(name2);
						}
					});
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", len);
		map.put("rows", list);
		return map;
	}

}
