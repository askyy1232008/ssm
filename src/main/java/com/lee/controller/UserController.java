package com.lee.controller;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.lee.pojo.User;
import com.lee.service.UserService;
import com.lee.utils.RedisUtil;
import com.lee.utils.ResultBuilder;
import com.lee.utils.StatusCode;

//  url:http://localhost:8080/ssm/user/showUser?id=1
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/test")
	@ResponseBody
	@CrossOrigin(origins="*",maxAge=3600)
	public Object test(HttpServletRequest request){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		JSONObject jobj = new JSONObject();
		jobj.put("user",user);
		ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
		return resultBuilder;
	}
	
	
	@RequestMapping("/login")
	@ResponseBody
	@CrossOrigin(origins="*",maxAge=3600)
	public Object login(HttpServletRequest request){
		User u = new User();
		u.setUserName(request.getParameter("userName"));
		u.setPassword(request.getParameter("password"));
		u = userService.login(u);
		if(u != null){
			UUID uuid = UUID.randomUUID();
			String token = String.valueOf(uuid);
			Integer userId = u.getId();
			RedisUtil.set(token,1800,userId);
			JSONObject jobj = new JSONObject();
			jobj.put("Token",token);
			ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
			return resultBuilder;
		}else{
			return "index";
		}
	}
}
