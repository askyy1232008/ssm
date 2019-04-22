package com.lee.utils;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public final class RequestParamObjFormatterBean {
	
	public static Object formatter(HttpServletRequest request,Class<?> classN){
		BufferedReader br;
		try {
			br = request.getReader();
			String str, wholeStr = "";
			while((str = br.readLine()) != null){
			         wholeStr += str;
			}
			Object obj= JSONObject.parseObject(wholeStr,classN);
			return obj;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
