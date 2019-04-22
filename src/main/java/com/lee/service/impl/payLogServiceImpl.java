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

import com.alibaba.fastjson.JSONObject;
import com.lee.dao.PayLogDao;
import com.lee.dao.SettlementDao;
import com.lee.dao.TruckDao;
import com.lee.dao.VoucherDao;
import com.lee.pojo.PayLog;
import com.lee.pojo.Settlement;
import com.lee.pojo.Truck;
import com.lee.pojo.Voucher;
import com.lee.service.PayLogService;
import com.lee.utils.DateUtil;
import com.lee.utils.ResultBuilder;
import com.lee.utils.StatusCode;

@Service("payLogService")
public class payLogServiceImpl implements PayLogService {

	@Resource
	private PayLogDao payLogDao;
	@Resource
	private SettlementDao settlementDao;
	@Resource
	private VoucherDao voucherDao;
	@Resource
	private TruckDao truckDao;

	@Override
	public Map<String, Object> getpayLogDatagrid(int currentpage, int pagesize, String lp, String tlp) {
		// TODO Auto-generated method stub
		List<PayLog> payLog = this.payLogDao.getPayLogDatagrid((currentpage - 1) * pagesize, pagesize, lp, tlp);
		Integer total = payLog.size();
		Map<String, Object> payLogList = new HashMap<String, Object>();
		payLogList.put("total", total);
		payLogList.put("rows", payLog);
		return payLogList;
	}

	@Override
	public int addPayLog(PayLog p) {
		// TODO Auto-generated method stub
		PayLog pl = new PayLog();
		pl.setTruckid(p.getTruckid());
		pl.setVoucherid(p.getVoucherid());
		pl.setLicenseplate(p.getLicenseplate());
		pl.setTrailerlicensepate(p.getTrailerlicensepate());
		pl.setPay(p.getPay());
		pl.setPayed((float) 0);
		pl.setSum(p.getSum());
		if (pl.getSum() <= 0) {
			pl.setFinished(true);
		} else {
			pl.setFinished(false);
		}
		pl.setPaydate(DateUtil.strToUtilDate(p.getRemarks(), "yyyy-MM-dd"));
		pl.setInsertdate(DateUtil.nowDate());
		pl.setLogit(true);
		pl.setRemarks("");
		int r2 = this.payLogDao.insert(pl);

		p.setPayed(p.getPayed() + p.getPay());
		p.setRemarks("");
		int r1 = this.payLogDao.updateByPrimaryKey(p);

		if (r1 > 0 && r2 > 0) {
			return 1;
		}
		return 1;
	}

	@Override
	public Object calculateSum1(Integer truckid, Integer voucherid, Date nowdate, Date voucherdate, Float allmoney,
			Integer months, Float moneyrate, String licenseplate, String trailerlicensepate) {
		// TODO Auto-generated method stub

		double zhinajin = 0.0005; // 滞纳金收取比例
		Integer zhinajindate = 5; // 下月几日开始收取滞纳金
		double allSum = (float) 0;
		String thisMonthVoucherDate = thisMonthVoucherDate(DateUtil.dateToStr(nowdate, "yyyy-MM-dd"),
				DateUtil.dateToStr(voucherdate, "yyyy-MM-dd"));
		List<PayLog> pls = this.payLogDao.getPayLogsByidOrderByPayDate(truckid, voucherid);
		Integer len = pls.size();
		Float notPayedFinishedMoney = pls.get(len - 1).getSum() - pls.get(len - 1).getPayed();
		Date notPayedFinishedDate = pls.get(len - 1).getPaydate();
		for (int i = 0; i < len; i++) {
			if (pls.get(i).getFinished()) {
				notPayedFinishedMoney = pls.get(i - 1).getSum() - pls.get(i - 1).getPayed();
				notPayedFinishedDate = pls.get(i - 1).getPaydate();
			}
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> notPayedFinished = new HashMap<String, Object>();
		notPayedFinished.put("notPayedFinishedMoney", notPayedFinishedMoney);
		notPayedFinished.put("notPayedFinishedDate", DateUtil.dateToStr(notPayedFinishedDate, "yyyy-MM-dd"));
		notPayedFinished.put("nextnotPayedFinishedDate",
				nextLastDate(DateUtil.dateToStr(notPayedFinishedDate, "yyyy-MM-dd"), zhinajindate));
		list.add(notPayedFinished);
		String nextrepaymentDate = DateUtil.dateToStr(notPayedFinishedDate, "yyyy-MM-dd");
		try {
			if (DateUtil.daysBetween(nextrepaymentDate, (beforeOneMonthVoucherDate(thisMonthVoucherDate))) > 0) {
				while (!(beforeOneMonthVoucherDate(thisMonthVoucherDate)).equals(nextrepaymentDate)) {
					nextrepaymentDate = nextrepaymentDate(nextrepaymentDate);
					Map<String, Object> notPayedFinished1 = new HashMap<String, Object>();
					PayLog pl = this.payLogDao.getPayLogByid(truckid, voucherid,
							DateUtil.strToSqlDate(nextrepaymentDate, "yyyy-MM-dd"));
					if (pl == null || "".equals(pl)) {
						PayLog p = new PayLog();
						p.setTruckid(truckid);
						p.setVoucherid(voucherid);
						p.setLicenseplate(licenseplate);
						p.setTrailerlicensepate(trailerlicensepate);
						p.setPaydate(DateUtil.strToSqlDate(nextrepaymentDate, "yyyy-MM-dd"));
						p.setSum((allmoney / months) * (1 + moneyrate));
						p.setPay((float) 0.00);
						p.setPayed((float) 0.00);
						p.setFinished(false);
						p.setLogit(false);
						p.setRemarks("");
						p.setInsertdate(nowdate);
						this.payLogDao.insert(p);
						notPayedFinished1.put("notPayedFinishedMoney", p.getSum() - p.getPayed());
						notPayedFinished1.put("notPayedFinishedDate", DateUtil.dateToStr(p.getPaydate(), "yyyy-MM-dd"));
						notPayedFinished1.put("nextnotPayedFinishedDate",
								nextLastDate(DateUtil.dateToStr(p.getPaydate(), "yyyy-MM-dd"), zhinajindate));
						list.add(notPayedFinished1);
					} else {
						notPayedFinished1.put("notPayedFinishedMoney", pl.getSum() - pl.getPayed());
						notPayedFinished1.put("notPayedFinishedDate",
								DateUtil.dateToStr(pl.getPaydate(), "yyyy-MM-dd"));
						notPayedFinished1.put("nextnotPayedFinishedDate",
								nextLastDate(DateUtil.dateToStr(pl.getPaydate(), "yyyy-MM-dd"), zhinajindate));
						list.add(notPayedFinished1);
					}
				}
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Map<String, Object> notPayedFinished2 = new HashMap<String, Object>();
		notPayedFinished2.put("notPayedFinishedMoney", (allmoney / months) * (1 + moneyrate));
		notPayedFinished2.put("notPayedFinishedDate", thisMonthVoucherDate);
		notPayedFinished2.put("nextnotPayedFinishedDate", DateUtil.dateToStr(nowdate, "yyyy-MM-dd"));
		list.add(notPayedFinished2);

		for (int i = 0; i < list.size(); i++) {
			Float notPayedFinishedMoneyList = (Float) list.get(i).get("notPayedFinishedMoney");
			String nextnotPayedFinishedDateList = (String) list.get(i).get("nextnotPayedFinishedDate");
			try {
				int days = DateUtil.daysBetween(nextnotPayedFinishedDateList, nowdate);
				System.out.println("days:" + days);
				if (days > 0) {
					allSum = allSum + notPayedFinishedMoneyList + notPayedFinishedMoneyList * zhinajin * days;
				} else {
					allSum = allSum + notPayedFinishedMoneyList;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		JSONObject jobj = new JSONObject();
		jobj.put("allSum", allSum);
		jobj.put("list", list);
		ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
		return resultBuilder;
	}

	public String nextLastDate(String date, Integer mydate) {
		Integer year = Integer.parseInt(date.split("-")[0]);
		Integer month = Integer.parseInt(date.split("-")[1]);
		String nextDate = "";
		if ((month + 1) > 12) {
			nextDate += String.valueOf(year + 1) + "-01-"
					+ (mydate < 10 ? "0" + String.valueOf(mydate) : String.valueOf(mydate));
		} else {
			nextDate += String.valueOf(year) + "-"
					+ (month + 1 < 10 ? "0" + String.valueOf(month + 1) : String.valueOf(month + 1)) + "-"
					+ (mydate < 10 ? "0" + String.valueOf(mydate) : String.valueOf(mydate));
		}
		return nextDate;
	}

	public String nextrepaymentDate(String date) {
		Integer year = Integer.parseInt(date.split("-")[0]);
		Integer month = Integer.parseInt(date.split("-")[1]);
		String day = date.split("-")[2];
		String nextDate = "";
		if ((month + 1) > 12) {
			nextDate += String.valueOf(year + 1) + "-01-" + day;
		} else {
			nextDate += String.valueOf(year) + "-"
					+ (month + 1 < 10 ? "0" + String.valueOf(month + 1) : String.valueOf(month + 1)) + "-" + day;
		}
		return nextDate;
	}

	public String thisMonthVoucherDate(String nowDate, String voucherDate) {
		String year = nowDate.split("-")[0];
		String month = nowDate.split("-")[1];
		String day = voucherDate.split("-")[2];
		return year + "-" + month + "-" + day;
	}

	public String beforeOneMonthVoucherDate(String thisMonthVoucherDate) {
		Integer year = Integer.parseInt(thisMonthVoucherDate.split("-")[0]);
		Integer month = Integer.parseInt(thisMonthVoucherDate.split("-")[1]);
		String day = thisMonthVoucherDate.split("-")[2];
		if ((month - 1) == 0) {
			month = 12;
			year = year - 1;
		} else {
			month = month - 1;
		}
		return String.valueOf(year) + "-" + (month < 10 ? "0" + String.valueOf(month) : String.valueOf(month)) + "-"
				+ day;
	}

	public String getThisMonthRepaymentDate(Date d, int day) {
		String date = DateUtil.dateToStr(d, "yyyy-MM-dd");
		Integer year = Integer.parseInt(date.split("-")[0]);
		Integer month = Integer.parseInt(date.split("-")[1]);
		return String.valueOf(year) + "-" + (month < 10 ? "0" + String.valueOf(month) : String.valueOf(month)) + "-"
				+ day;
	}

	@Override
	public Object calculateSum(Integer truckid, Integer voucherid, Date nowdate, Date voucherdate, Float allmoney,
			Integer months, Float moneyrate, Float repaymentPay) {
		// TODO Auto-generated method stub
		Date now = DateUtil.nowDate();
		String settlementDate = getThisMonthRepaymentDate(now, 25);
		int result = this.settlementDao.count(DateUtil.strToUtilDate(settlementDate, "yyyy-MM-dd"));
		if(result >0){
			ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(null, StatusCode.FALL);
			return resultBuilder;
		}
		String firstDate = getThisMonthRepaymentDate(now, 5);
		int day = 0;
		try {
			day = DateUtil.daysBetween(firstDate, nowdate);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		if (day <= 0) {
			nowdate = DateUtil.strToUtilDate(firstDate, "yyyy-MM-dd");
		}
		String thisMonthVoucherDate = thisMonthVoucherDate(DateUtil.dateToStr(nowdate, "yyyy-MM-dd"),
				DateUtil.dateToStr(voucherdate, "yyyy-MM-dd"));
		String beforeOneMonthVoucherDate = beforeOneMonthVoucherDate(thisMonthVoucherDate);
		String thisMonthLastDate = nextLastDate(beforeOneMonthVoucherDate, 5);
		PayLog p = this.payLogDao.getPayLogByid(truckid, voucherid,
				DateUtil.strToSqlDate(thisMonthVoucherDate, "yyyy-MM-dd"));
		int days = 0;
		try {
			days = DateUtil.daysBetween(thisMonthLastDate, nowdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float num = (p.getSum() - (allmoney / months) * (1 + moneyrate));
		if (repaymentPay >= 0) {
			if (num <= 0) {
				p.setSum(num - repaymentPay + (allmoney / months) * (1 + moneyrate));
			} else {
				if (repaymentPay >= num) {
					if (days > 0) {
						p.setSum((float) ((num - repaymentPay) + num * 0.0005 * days
								+ (allmoney / months) * (1 + moneyrate)));
					} else {
						p.setSum((float) (num - repaymentPay + (allmoney / months) * (1 + moneyrate)));
					}
				} else {
					if (days > 0) {
						p.setSum((float) ((num - repaymentPay) + repaymentPay * 0.0005 * days
								+ (allmoney / months) * (1 + moneyrate)));
					} else {
						p.setSum((float) (num - repaymentPay + (allmoney / months) * (1 + moneyrate)));
					}
				}
			}
		}
		JSONObject jobj = new JSONObject();
		jobj.put("p", p);
		ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
		return resultBuilder;
	}

	@Override
	public int settlement(Date nowDate) {
		// TODO Auto-generated method stub
		int r1 = 0, r2 = 0, r3 = 0;
		String nowDateStr = DateUtil.dateToStr(nowDate, "yyyy-MM-dd");
		System.out.println(nowDateStr);
		String[] arr = nowDateStr.split("-");
		String day = arr[2];
		if ("25".equals(day)) {
			if (this.settlementDao.count(nowDate) == 0) {
				System.out.println(this.settlementDao.count(nowDate));
				Settlement s = new Settlement();
				s.setSettlementdate(nowDate);
				r1 = this.settlementDao.insert(s);

				List<PayLog> list = this.payLogDao.getNotFinished();
				int len = list.size();

				for (int i = 0; i < len; i++) {
					PayLog p = list.get(i);
					PayLog pl = new PayLog();
					pl.setTruckid(p.getTruckid());
					pl.setVoucherid(p.getVoucherid());
					pl.setLicenseplate(p.getLicenseplate());
					pl.setTrailerlicensepate(p.getTrailerlicensepate());
					pl.setPaydate(DateUtil.strToUtilDate(
							nextrepaymentDate(DateUtil.dateToStr(p.getPaydate(), "yyyy-MM-dd")), "yyyy-MM-dd"));
					Voucher v = this.voucherDao.getVoucherByTruckIdAndLoanType(p.getTruckid(), "以欠款计算");
					if (DateUtil.sameDate(p.getPaydate(), p.getInsertdate())) {
						pl.setSum(p.getSum() + ((v.getSum() / v.getMonths()) * (1 + v.getMoneyrate())));
					} else {
						if (p.getSum() > 0) {
							pl.setSum((float) ((p.getSum()-(v.getSum() / v.getMonths()) * (1 + v.getMoneyrate()))* 0.0005 * 20 + p.getSum() + ((v.getSum() / v.getMonths()) * (1 + v.getMoneyrate()))));
						} else {
							pl.setSum(p.getSum() + ((v.getSum() / v.getMonths()) * (1 + v.getMoneyrate())));
						}
					}
					pl.setPay((float) 0);
					pl.setPayed((float) 0);
					pl.setFinished(false);
					pl.setLogit(false);
					pl.setRemarks("");
					pl.setInsertdate(nowDate);
					PayLog p2 = this.payLogDao.getPayLogByid(pl.getTruckid(), pl.getVoucherid(), pl.getPaydate());
					if (p2 == null || "".equals(p2)) {
						r2 = this.payLogDao.insert(pl);
					} else {
						r2 = 0;
					}
					p.setFinished(true);
					r3 = this.payLogDao.updateByPrimaryKey(p);
				}
			}
		}
		if (r1 > 0 && r2 > 0 && r3 > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public PayLog getPayLogByid(Integer truckid, Integer voucherid, Date paydate) {
		// TODO Auto-generated method stub
		return this.payLogDao.getPayLogByid(truckid, voucherid, paydate);
	}

	@Override
	public int countSettlementByDate(Date d) {
		// TODO Auto-generated method stub
		System.out.println(this.settlementDao.count(d));
		return this.settlementDao.count(d);
	}

	@Override
	public Map<String, Object> repaymentOverRent(String name, int currentpage, int pagesize) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if ("repaymentOverRent".equals(name)) {
			List<PayLog> pls = this.payLogDao.getNotFinishedDatagrid((currentpage - 1) * pagesize, pagesize);
			int len = pls.size();
			for (PayLog p : pls) {
				Integer truckid = p.getTruckid();
				Voucher v = this.voucherDao.getVoucherByTruckIdAndLoanType(truckid, "以欠款计算");
				Truck t = this.truckDao.selectByPrimaryKey(truckid);
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("licensePlate", t.getLicenseplate());
				m.put("trailerLicensePate", t.getTrailerlicensepate());
				m.put("money", p.getSum());
				m.put("month", (v.getSum() / v.getMonths()) * (1 + v.getMoneyrate()));
				list.add(m);
			}
			Collections.sort(list, new Comparator<Map<String, Object>>() {
				@Override
				public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
					// TODO Auto-generated method stub
					Double name1 = Double.valueOf(Double.parseDouble(arg0.get("money").toString())
							- Double.parseDouble(arg0.get("month").toString()));// name1是从你list里面拿出来的一个
					Double name2 = Double.valueOf(Double.parseDouble(arg1.get("money").toString())
							- Double.parseDouble(arg0.get("month").toString())); // name1是从你list里面拿出来的第二个name
					return name2.compareTo(name1);
				}
			});
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("total", len);
			map.put("rows", list);
			return map;
		}
		try {
			if ("lastPay".equals(name)) {
				Date nowDate = DateUtil.nowDate();
				List<Voucher> vs = this.voucherDao.getVouchers((currentpage - 1) * pagesize, pagesize);
				int len = vs.size();
				for (Voucher v : vs) {
					Truck t = this.truckDao.selectByPrimaryKey(v.getTruckid());
					Map<String, Object> m = new HashMap<String, Object>();
					Date d = this.payLogDao.getLastShowPayLog(t.getTruckid());
					if (d == null) {
						continue;
					} else {
						m.put("licensePlate", t.getLicenseplate());
						m.put("trailerLicensePate", t.getTrailerlicensepate());
						m.put("lastpayDate", d);
						m.put("days", DateUtil.daysBetween(d, nowDate));
						list.add(m);
					}
				}
				Collections.sort(list, new Comparator<Map<String, Object>>() {
					@Override
					public int compare(Map<String, Object> arg0, Map<String, Object> arg1) {
						// TODO Auto-generated method stub
						Integer name1 = Integer.valueOf(arg0.get("days").toString());// name1是从你list里面拿出来的一个
						Integer name2 = Integer.valueOf(arg1.get("days").toString()); // name1是从你list里面拿出来的第二个name
						return name1.compareTo(name2);
					}
				});
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("total", len);
				map.put("rows", list);
				return map;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> payLogListForNotShow(int currentpage, int pagesize, String lp, String tlp) {
		// TODO Auto-generated method stub
		List<PayLog> payLog = this.payLogDao.payLogListForNotShow((currentpage - 1) * pagesize, pagesize, lp, tlp);
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		for(PayLog p :payLog){
			String licensePlate = p.getLicenseplate();
			String trailerLicensePate = p.getTrailerlicensepate();
			Integer truckid = p.getTruckid();
			Voucher v = this.voucherDao.getVoucherByTruckIdAndLoanType(truckid, "以欠款计算");
			Map<String,Object> m = new HashMap<String,Object>();
			m.put("licensePlate", licensePlate);
			m.put("trailerLicensePate", trailerLicensePate);
			if((p.getSum()-(v.getSum()/v.getMonths())*(1+v.getMoneyrate()))>=0){
				m.put("previous", (p.getSum()-(v.getSum()/v.getMonths())*(1+v.getMoneyrate())));
				m.put("zhinajin", (p.getSum()-(v.getSum()/v.getMonths())*(1+v.getMoneyrate()))*0.0005*20);
			}else{
				m.put("previous", 0);
				m.put("zhinajin", 0);
			}
			m.put("allNeedPay", p.getSum()+p.getPayed()+Double.parseDouble(m.get("zhinajin").toString()));
			m.put("payed", p.getPayed());
			m.put("needPay", p.getSum()+Double.parseDouble(m.get("zhinajin").toString()));
			list.add(m);
		}
		Integer total = payLog.size();
		Map<String, Object> payLogList = new HashMap<String, Object>();
		payLogList.put("total", total);
		payLogList.put("rows", list);
		return payLogList;
	}

	@Override
	public List<PayLog> getPayLogByTruckId(Integer truckid) {
		// TODO Auto-generated method stub
		return this.payLogDao.getPayLogByTruckId(truckid);
	}

	@Override
	public int updatePayLog(PayLog p) {
		// TODO Auto-generated method stub
		return this.payLogDao.updateByPrimaryKey(p);
	}
}
