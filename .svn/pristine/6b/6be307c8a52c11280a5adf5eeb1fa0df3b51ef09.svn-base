package com.lee.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lee.dao.PayLogDao;
import com.lee.dao.TruckDao;
import com.lee.dao.VoucherDao;
import com.lee.pojo.PayLog;
import com.lee.pojo.Truck;
import com.lee.pojo.Voucher;
import com.lee.service.VoucherService;
import com.lee.utils.BeanUtil;
import com.lee.utils.DateUtil;

@Service("voucherService")
public class VoucherServiceImpl implements VoucherService {

	@Resource
	private VoucherDao voucherDao;
	@Resource
	private TruckDao truckDao;
	@Resource
	private PayLogDao payLogDao;
	
	@Override
	public Map<String, Object> getVoucherDatagrid(int currentpage, int pagesize, String lp,String tlp) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> vouchers = this.voucherDao.getVoucherDatagrid((currentpage - 1) * pagesize, pagesize,lp,tlp);
		List<Map<String, Object>> list = vouchers;
		for(int i=0;i<vouchers.size();i++){
			Map<String, Object> map = BeanUtil.transBean2Map(list.get(i));
			Map<String, Object> m = BeanUtil.transBean2Map(vouchers.get(i));
			map.remove("truckid");
			map.remove("truck");
			Truck t = (Truck)m.get("truck");
			map.put("truckid",t.getTruckid());
			map.put("licenseplate",t.getLicenseplate());
			map.put("trailerlicensepate",t.getTrailerlicensepate());
			list.set(i, map);
		}
		int total = this.voucherDao.countVoucher(lp,tlp);
		Map<String, Object> TruckList = new HashMap<String, Object>();
		TruckList.put("total", total);
		TruckList.put("rows", list);
		return TruckList;
	}

	@Override
	public int addVoucher(Voucher v,String lp ,String tlp) {
		// TODO Auto-generated method stub
		Integer truckid = v.getTruckid();
		String loantype = v.getLoantype();
		int resultInsert ;
		if(truckid == null || truckid == 0){
			return 0;
		}else{
			int count = this.voucherDao.countVoucherByTruckIdAndLoanType(truckid, loantype);
			if(count>0){
				return 0;
			}
			v.setTruckid(truckid);
			resultInsert = this.voucherDao.insert(v);
		}
		Integer voucherid = this.voucherDao.getLastVoucher();
		String licenseplate = lp;
		String trailerlicensepate = tlp;
		Date paydate = v.getVoucherdate();
		Float sum = (v.getSum()/v.getMonths())*(1+v.getMoneyrate());
		Float pay = (float) 0.00;
		Float payed = (float) 0.00;
		Boolean finished = false;
		Boolean logit = false;
		String remarks = "";
		Date insertdate = v.getVoucherdate();
		
		
		PayLog p = new PayLog();
		p.setTruckid(truckid);
		p.setVoucherid(voucherid);
		p.setLicenseplate(licenseplate);
		p.setTrailerlicensepate(trailerlicensepate);
		p.setPaydate(paydate);
		p.setSum(sum);
		p.setPay(pay);
		p.setPayed(payed);
		p.setFinished(finished);
		p.setLogit(logit);
		p.setRemarks(remarks);
		p.setInsertdate(insertdate);
		
		Integer result = this.payLogDao.insert(p);
		
		if(resultInsert>0 && result>0){
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteVoucher(Integer id) {
		// TODO Auto-generated method stub
		return this.voucherDao.deleteByPrimaryKey(id);
	}

	@Override
	public Voucher getVoucherByTruckIdAndLoanType(Integer truckid, String loanType) {
		// TODO Auto-generated method stub
		return this.voucherDao.getVoucherByTruckIdAndLoanType(truckid, loanType);
	}

	@Override
	public Map<String,Object> getContract(Integer currentpage,Integer pagesize) {
		// TODO Auto-generated method stub
		List<Voucher> vouchers = this.voucherDao.getVouchers((currentpage - 1) * pagesize, pagesize);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int len = vouchers.size();
		Date nowDate = DateUtil.nowDate();
		try{
			for(Voucher v : vouchers){
				Date voucherDate = v.getVoucherdate();
				Integer months = v.getMonths();
				Integer truckid = v.getTruckid();
				Truck t = this.truckDao.selectByPrimaryKey(truckid);
				String contractDate = DateUtil.addMonth(DateUtil.dateToStr(voucherDate, "yyyy-MM-dd"), "yyyy-MM-dd", months);
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("licensePlate",t.getLicenseplate());
				m.put("trailerLicensePate",t.getTrailerlicensepate());
				m.put("contractDate",contractDate);
				m.put("days",DateUtil.daysBetween(nowDate, DateUtil.strToSqlDate(contractDate, "yyyy-MM-dd")));
				list.add(m);
			}
			Collections.sort(list, new Comparator<Map<String, Object>>() {
				@Override
				public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
					// TODO Auto-generated method stub
					Integer name1 = Integer.valueOf(arg0.get("days").toString());// name1是从你list里面拿出来的一个
					Integer name2 = Integer.valueOf(arg1.get("days").toString()); // name1是从你list里面拿出来的第二个name
					return name2.compareTo(name1);
				}
			});
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", len);
			map.put("rows", list);
			return map;
		}catch(Exception e){
			e.getStackTrace();
		}
		return null;
	}

}
