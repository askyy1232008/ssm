package com.lee.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lee.dao.TempDataDao;
import com.lee.dao.TokenDao;
import com.lee.pojo.TempData;
import com.lee.pojo.Token;
import com.lee.utils.DateUtil;
//import test.SpringMVC.OpenAPIUtil;
import com.lee.utils.OpenAPIUtil;

@Controller
@RequestMapping("/openAPI")
public class OpenAPIController {

	@Resource(name="tokenDao")
	private TokenDao tokenDao;
	
	@Resource(name="tempDataDao")
	private TempDataDao tempDataDao;
	
	
	@RequestMapping("/rajectory")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object rajectory(HttpServletRequest request){
		String license = request.getParameter("license");
		String qryBtm = request.getParameter("dtStart");
		String qryEtm = request.getParameter("dtEnd");
		int r = this.tempDataDao.countData(license, DateUtil.strToSqlDate(qryBtm, "yyyy-MM-dd HH:mm:ss"), DateUtil.strToSqlDate(qryEtm, "yyyy-MM-dd HH:mm:ss"));
		if(r>0){
			TempData temp = this.tempDataDao.getTempData(license, DateUtil.strToSqlDate(qryBtm, "yyyy-MM-dd HH:mm:ss"), DateUtil.strToSqlDate(qryEtm, "yyyy-MM-dd HH:mm:ss"));
			JSONObject obj = JSONObject.parseObject(temp.getTempdata());
			String status = obj.getString("status");
			if("1001".equals(status)){
				return obj;
			}else{
				Map<String,Object> m = new HashMap<String,Object>();
				m.put("status",Integer.parseInt(status));
				m.put("error", OpenAPIUtil.errorMsg(status));
				return m;
			}
		}else{
			Token t  = this.tokenDao.selectByPrimaryKey(2);
			String token = t.getToken();
			String result = OpenAPIUtil.vHisTrack24(token, license, qryBtm, qryEtm);
			JSONObject obj = JSONObject.parseObject(result);
			String status = obj.getString("status");
			if("1016".equals(status)){
				String res = OpenAPIUtil.login();
				token  = JSONObject.parseObject(res).getString("result");
				Token t1 = new Token();
				t1.setId(2);
				t1.setToken(token);
				this.tokenDao.updateByPrimaryKey(t1);
				result = OpenAPIUtil.vHisTrack24(token, license, qryBtm, qryEtm);
				obj = JSONObject.parseObject(result);
				status = obj.getString("status");
			}
			if("1001".equals(status)){
				TempData td = new TempData();
				td.setLicenseplate(license);
				td.setTempdata(result);
				td.setStarttime(DateUtil.strToSqlDate(qryBtm, "yyyy-MM-dd HH:mm:ss"));
				td.setEndtime(DateUtil.strToSqlDate(qryEtm, "yyyy-MM-dd HH:mm:ss"));
				this.tempDataDao.insertSelective(td);
				return obj;
			}else{
				Map<String,Object> m = new HashMap<String,Object>();
				m.put("status",Integer.parseInt(status));
				m.put("error", OpenAPIUtil.errorMsg(status));
				return m;
			}
			
		}
	}
	
}
