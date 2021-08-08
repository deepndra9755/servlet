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

public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pww=res.getWriter();
		String name=null,pass=null;
		name=(String)req.getAttribute("name");
		pass=(String)req.getAttribute("pass");
		HttpSession des=req.getSession();
		String val=(String)des.getAttribute("value1");
		int val2=(Integer)des.getAttribute("value2");
		pass=(String)req.getAttribute("pass");
		pww.println("this is from second servlet"+name+" "+pass);
		pww.println("this is from  second servlet"+val+" "+val2);
		
	ServletContext sc=req.getServletContext();
		RequestDispatcher rd=sc.getRequestDispatcher("/reqAtt2");
		rd.forward(req, res);
		
	}


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
