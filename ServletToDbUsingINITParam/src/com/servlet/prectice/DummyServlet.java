package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  public static final String QRY_TO_SEARCH_in="SELECT NAME,ADDRESS,SALLARY,JOB FROM CIVIL WHERE PERSONID=? ";

   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   doPost(request, response);
	   
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		java.sql.ResultSetMetaData rsm=null;
	    int inp=0;
	   
     	pw=response.getWriter();
    	response.setContentType("text/html");
    	
    	
    	try {
			Class.forName(getInitParameter("classNm"));  //now it is optional 
			
		       con=DriverManager.getConnection(getInitParameter("url"),getInitParameter("user"),getInitParameter("pass"));//getting connection
		              if(con!=null)
		              ps =con.prepareStatement(QRY_TO_SEARCH_in);                                   //getting precompile Qurey
    	              if(ps!=null)
		              pw.println(ps);
		               
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
	}

}
