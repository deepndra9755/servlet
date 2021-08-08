package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=null;   
		pw=response.getWriter();
		String name=null;
		String Lastname=null;
		String child =request.getParameter("child");
		String cage=request.getParameter("cage");
		 name =request.getParameter("hd");
		 Lastname=request.getParameter("hh");
		
			
			pw.println("<h1> this is your name  "+name+"</h1>");
			pw.println("<h1> this is last name  "+Lastname+"</h1>");
			
		pw.println("<h1> this the age of child"+cage+"</h1>");
		pw.println("<h1> this is the child count"+child+"</h1>");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
