package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class four extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pww=res.getWriter();
		String name=null,pass=null;
		name=(String)req.getAttribute("name");
		pass=(String)req.getAttribute("pass");
		HttpSession des=req.getSession();
		int val=(Integer)des.getAttribute("value");
		int val2=(Integer)des.getAttribute("value2");
		
		pww.println("this is from third servlet"+name+" "+pass);
		pww.println("this is http sesstion from third servlet"+val+" "+val2);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
