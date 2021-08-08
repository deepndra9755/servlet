/*
 * servlet to database communication using init param useing web-xml
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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.xdevapi.Result;

/**
 * Servlet implementation class ServletToDatabase
 */
public class DbComUsingINIT extends HttpServlet {
	//class opening
	
  public static final String QRY_TO_SEARCH="SELECT NAME,ADDRESS,SALLARY,JOB FROM CIVIL WHERE PERSONID=? ";
//SQL Query for Communication
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=null;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		java.sql.ResultSetMetaData rsm=null;
	    int inp=0;
	   
     	pw=response.getWriter();
    	response.setContentType("text/html");
    	inp=Integer.parseInt(request.getParameter("id"));
    	String jjj=getInitParameter("initparam");
    	
    	try {
			Class.forName(getInitParameter("classNm"));  //now it is optional 
			
		       con=DriverManager.getConnection(getInitParameter("url"),getInitParameter("user"),getInitParameter("pass"));//getting connection
		              if(con!=null)
		              ps =con.prepareStatement(QRY_TO_SEARCH);                                   //getting precompile Qurey
    	              if(ps!=null)
		              ps.setInt(1,inp);
		               
		              rs=ps.executeQuery();
		              int j=0;
		              rsm=rs.getMetaData();
		              j =rsm.getColumnCount(); 
		              
		              while(j!=0)
		              {
		            
		               pw.print(rsm.getColumnName(j));
		               j--;
		              }
		               pw.println("this is "+jjj);
		              if(rs!=null&&rs.next())
		              {
		            	  
		            	 pw.print("<h1>");
		            	pw.print(rs.getString(1)+" |"+rs.getString(2)+"  |"+rs.getString(3)+"  |"+rs.getString(4));
		            	pw.print("</h1>");
		              }
		              else
		              {
		            	pw.print("<h1>failed to connect</h1>");  
		              }
		            	  
		            	  
		              
    	} 
    	
       catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
