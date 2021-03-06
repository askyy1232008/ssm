package com.lee.controller;

import java.util.Map;
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

//  url:http://localhost:8080/ssm/user/userList
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;

	@RequestMapping("/userList")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object getUserDatagrid(HttpServletRequest request) {
		String rows = request.getParameter("rows");
		String page = request.getParameter("page");
		int currentpage = Integer.parseInt(("0".equals(page)||page == null) ? "1": page);//第几页
		int pagesize = Integer.parseInt(("0".equals(rows)||rows == null) ? "10": rows);//每页多少行
		Map<String, Object> users = this.userService.getUserDatagrid(currentpage,pagesize);
		return users;
	}

	@RequestMapping("/addUser")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int addUser(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"), 10);
		if (userName != null && !userName.equals("") && password != null && !password.equals("") && age > 0
				&& age < 100) {
			User u = new User();
			u.setUserName(userName);
			u.setPassword(password);
			u.setAge(age);
			int number = this.userService.addUser(u);
			return number;
		} else {
			return 0;
		}

	}

	@RequestMapping("/updateUser")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int updateUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"), 10);
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int age = Integer.parseInt(request.getParameter("age"), 10);
		if (userName != null && !userName.equals("") && password != null && !password.equals("") && age > 0
				&& age < 100) {
			User u = new User();
			u.setId(id);
			u.setUserName(userName);
			u.setPassword(password);
			u.setAge(age);
			int number = this.userService.updateUser(u);
			return number;
		} else {
			return 0;
		}

	}

	@RequestMapping("/removeUser")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public int removeUser(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"), 10);
		int number = this.userService.removeUser(id);
		return number;
	}

	@RequestMapping("/error")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object errorPage(HttpServletRequest request) {
		String msg = request.getParameter("errorMessage");
		JSONObject jobj = new JSONObject();
		jobj.put("errorMessage", msg);
		ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.FALL);
		return resultBuilder;
	}

	@RequestMapping("/login")
	@ResponseBody
	@CrossOrigin(origins = "*", maxAge = 3600)
	public Object login(HttpServletRequest request) {
		User u = new User();
		u.setUserName(request.getParameter("userName"));
		u.setPassword(request.getParameter("password"));
		u = userService.login(u);
		if (u != null) {
			UUID uuid = UUID.randomUUID();
			String token = String.valueOf(uuid);
			Integer userId = u.getId();
			RedisUtil.set(token, 1800, userId);
			JSONObject jobj = new JSONObject();
			jobj.put("Token", token);
			jobj.put("userName", u.getUserName());
			jobj.put("age", u.getAge());
			ResultBuilder<JSONObject> resultBuilder = new ResultBuilder<>(jobj, StatusCode.SUCCESS);
			return resultBuilder;
		} else {
			return "login";
		}
	}
}
