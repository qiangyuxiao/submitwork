package com.work;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class control extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String url=req.getRequestURI();
		url=url.substring(url.lastIndexOf("/")+1, url.lastIndexOf("."));
		try {
			Class clazz=Class.forName("com.work."+url);
			String method=req.getParameter("method");
			System.out.println("url:"+url+"method:"+method);
			Method me=clazz.getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			me.invoke(clazz.newInstance(), req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

