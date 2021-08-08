package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCylDemo extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("from 1 param init method");
		System.out.println(config.getInitParameter("className"));
		
	}
	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
	System.out.println("from  second servlice method");
	
	PrintWriter pw=arg1.getWriter();
	pw.println("<h1>from h1 tag inside servlet</h1>");
	}
	
	public void service(ServletRequest arg12, ServletResponse arg11) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("from first servlet method");
		
		PrintWriter pw=arg11.getWriter();
		pw.println("<h1>from h1 tag inside first servlet</h1>");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	    System.out.println("from  destroy method");
	}

}
