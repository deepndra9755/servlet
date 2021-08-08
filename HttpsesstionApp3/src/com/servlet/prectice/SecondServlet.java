package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=null;   
		pw=response.getWriter();
		String name=null;
		Cookie jop=null;
		Cookie jop1=null,check=null;
		String Lastname=null,when=null,why=null;
		
		 Cookie kpo[] =request.getCookies();
		 
		if(kpo!=null)
		{
		 jop=kpo[0];
		jop1=kpo[1];
		check=kpo[2];
		
		}
		 
	      
	
		String child =request.getParameter("child");
		String cage=request.getParameter("cage");
		pw.println("<h1> this is from check cookie  "+check.getValue()+"</h1>");
			
			pw.println("<h1> this is your name  "+jop.getValue()+"</h1>");
			pw.println("<h1> this is your last  "+jop1.getValue()+"</h1>");
			
		pw.println("<h1> this the age of child"+cage+"</h1>");
		pw.println("<h1> this is the child count"+child+"</h1>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
