/*
 * servlet to database communication using eclipse id
 * team :-indivisual task
 * version :- 1.0
 * approach 2 for db communication
 */

package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletToDatabase
 */
@WebServlet("/ServletToDatabase")
public class ServletToDatabase extends HttpServlet {
	//class opening
	
//  public static final String QRY_TO_SEARCH="SELECT NAME,ADDRESS,SALLARY,JOB FROM CIVIL WHERE PERSONID=? ";
//SQL Query for Communication
     // Connection con1=null;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    PrintWriter pw=null;   
		pw=res.getWriter();
		float amt=0.0f;
		res.setContentType("text/html");
		amt=Float.parseFloat(req.getParameter("name"));
		
         
		
		if(amt>5000)
		{
		 int per=2;
		 int yy=100;
		 float out;
		 
		out=amt*2/yy;
		pw.println("<h1>this is tax of state level"+out+"</h1>");
		

		ServletContext sc=getServletContext();
	   //	RequestDispatcher rd=sc.getRequestDispatcher("/find");
		
	   	
		ServletContext ho=sc.getContext("/central");
		 
		RequestDispatcher Re=ho.getRequestDispatcher("/central");
       
         Re.include(req, res);
		
		}
		
		//pw.println("<h1>"+name+"</h1>");
		
		
		
	  
     	}

}
