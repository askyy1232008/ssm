package com.lee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lee.utils.DateUtil;
import com.lee.utils.MD5;
import com.lee.utils.RedisUtil;
import java.sql.Timestamp;

/**
 * Servlet Filter implementation class CheckFilter
 */
public class CheckFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public CheckFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		// 不过滤的uri
		String[] notFilter = new String[] { "/login" };

		// 请求的uri
		String uri = httpRequest.getRequestURI();
		System.out.println("filter>>>uri>>>" + uri);

		// 是否过滤
		boolean doFilter = true;
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// uri中包含不过滤uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		if (doFilter) {
			System.out.println("doFilter>>>");
			//判定token是否有效
			String token = httpRequest.getParameter("token");
			if(!RedisUtil.exists(token)){
				System.out.println("token无效或不存在！");
				return;
			}
			//判定是否超时  5分钟
			String timestamp = httpRequest.getParameter("timestamp"); 
			int time1 = Integer.parseInt(timestamp);  //请求时间戳
			int time2 = (int) (System.currentTimeMillis() /1000); //系统当前时间戳
			long s = (time2 - time1) / 60;
			if(s>5){
				System.out.println("时间戳超时!");
				return;
			}
			//判定签名是否正确
			List<String> name = new ArrayList<String>();
			List<String> value = new ArrayList<String>();
			Enumeration<String> myenum = httpRequest.getParameterNames();
			while (myenum.hasMoreElements()) {
				String paramName = (String) myenum.nextElement();
				String paramValue = httpRequest.getParameter(paramName);
				name.add(paramName);
				value.add(paramValue);
			}
			String uSign = name.get(0) + "=" + value.get(0);
			for (int i = 1; i < name.size()-2; i++) {
				uSign += "&" + name.get(i) + "=" + value.get(i);
			}
			String sign = MD5.getMd5(uSign);
			if (!sign.equals(httpRequest.getParameter("sign"))) {
				System.out.println("签名错误!");
				return;
			}
			//拒绝重复调用  5分钟
			if(RedisUtil.exists(sign)){
				System.out.println("拒绝重复调用!");
				return;
			}
			//首次调用缓存sign 5分钟
			System.out.println("首次调用>>");
			RedisUtil.set(sign,300,"sign");
			System.out.println("pass Filter>>");
			chain.doFilter(request, response);
			
		} else {
			System.out.println("no Filter>>>");
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * is Ajax request
	 * 
	 * @param request
	 * @return
	 */
	/*private boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header)) {
			// ajax request
			return true;
		} else {
			// traditional sync http request
			return false;
		}
	}*/
}
