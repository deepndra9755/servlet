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

public class ServletFirst extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   
		PrintWriter pw=null;   
		pw=res.getWriter();
		String name=null,name2=null;
		String marry=req.getParameter("marr");
		
		name=req.getParameter("name");
		name2=req.getParameter("lst");
		
		if(marry.equalsIgnoreCase("m"));
		{
			//pw.println("<h1>"+name+"</h1>");   
			//pw.println("<h1>"+marry+"</h1>"); 
			//<form action ="find" method ="POST">
			name="'"+name+"'";
			name2="'"+name2+"'";
			//<h3 style="color:white"><input type ="submit" value ="Submit">
			pw.println("<form action='uolo' method='POST'>");
			pw.println("<h2 style=color:blue;><input type='text' name=child>how many child you have");
			pw.println("<h2 style='color:blue'><input type='text' name=cage>what is age of child");
			pw.println("<h2 style='color:blue'><input type='hidden' name=hd value="+name+">");
			pw.println("<h2 style='color:blue'><input type='hidden' name=hh value="+name2+">");
			pw.println("<h2 style='color:white'>submit&nbsp;<input type='submit'>");
			pw.println("</form>");
			
			pw.println();
		}
		//name=req.getParameter("marry");
//		pw.println("<h1>"+name+"</h1>");   
//		//pw.println("<h1>"+marry+"</h1>"); 
//		<form action ="find" method ="POST">
//		pw.println("<form");   
//		pw.println(); 
//		
		}
		
		//pw.println("<h1>"+name+"</h1>");
		
		
		
	  
     	}


