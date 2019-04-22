package com.lee.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.dao.TruckOwnerDao;
import com.lee.pojo.TruckOwner;
import com.lee.service.TruckOwnerService;

@Service("truckOwnerService")
public class TruckOwnerServiceImpl implements TruckOwnerService {

	@Resource(name = "truckOwnerDao")
	private TruckOwnerDao truckOwnerDao;

	@Override
	public List<TruckOwner> getTruckOwner(Integer truckid) {
		// TODO Auto-generated method stub
		return this.truckOwnerDao.getTruckOwnerByTruckid(truckid);
	}

	@Override
	public int addTruckOwner(TruckOwner to) {
		// TODO Auto-generated method stub
		return this.truckOwnerDao.insertSelective(to);
	}

	@Override
	public int updateTruckOwner(TruckOwner to) {
		// TODO Auto-generated method stub
		return this.truckOwnerDao.updateByPrimaryKeySelective(to);
	}

}
