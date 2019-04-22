package com.lee.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.lee.pojo.Truck;

public interface TruckDao {
    int deleteByPrimaryKey(Integer truckid);

    int insert(Truck record);

    int insertSelective(Truck record);

    Truck selectByPrimaryKey(Integer truckid);

    int updateByPrimaryKeySelective(Truck record);

    int updateByPrimaryKey(Truck record);
    
    List<Map<String,Object>> getTruckDatagrid(@Param("offset") int offset, @Param("limit") int limit,
			@Param("tc") String truckingcompany, @Param("lp") String licenseplate,
			@Param("tl") String trailerlicensepate);

	int countTrucks(@Param("tc") String truckingcompany, @Param("lp") String licenseplate,
			@Param("tl") String trailerlicensepate);

	Integer getIdByLicenseplate(@Param("lp") String licenseplate,
			@Param("tl") String trailerlicensepate);
	Integer countTruckByLPAndTL(@Param("lp") String licenseplate,
			@Param("tl") String trailerlicensepate);
	
	List<Truck> getTrucks(@Param("datename") String datename,@Param("offset") int offset, @Param("limit") int limit);
	
	List<Truck> getTrucks1(@Param("offset") int offset, @Param("limit") int limit);
	
	Truck getTheLastTruck();
	
	List<Truck> getAllTrucks();
}