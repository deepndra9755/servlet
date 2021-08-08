package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pww=res.getWriter();
		String name=null,pass=null;
		name=req.getParameter("user");
		pass=req.getParameter("pass");
		HttpSession ses=req.getSession();
		ses.setAttribute("value", 10);
		ses.setAttribute("value2", 20);
		req.setAttribute("name",name);
		req.setAttribute("pass",pass);
		pww.println("this is from first servlet"+name+" "+pass);
		req.setAttribute(name,pass);
		
		
		ServletContext sc=req.getServletContext();
		RequestDispatcher rd=sc.getRequestDispatcher("/reqAtt2");
		rd.forward(req, res);
		
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
