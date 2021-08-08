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
	
  public static final String QRY_TO_SEARCH="SELECT NAME,ADDRESS,SALLARY,JOB FROM CIVIL WHERE PERSONID=? ";
//SQL Query for Communication
      Connection con1=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

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
    	try {
//			Class.forName("com.mysql.cj.jdbc.Driver");  //now it is optional 
//			
//		       con=DriverManager.getConnection("jdbc:mysql://@localhost:3306/emp","root","root");//getting connection
//		              if(con!=null)
//		              ps =con.prepareStatement(QRY_TO_SEARCH);                                   //getting precompile Qurey
//    	              if(ps!=null)
    		           
						DataSource gh =getcon();
						con=gh.getConnection();
						
						 if(con!=null)
				          ps =con.prepareStatement(QRY_TO_SEARCH);                                   //getting precompile Qurey
	    	              if(ps!=null)
	    	             ps.setInt(1,inp); 
					
		             // ps.setInt(1,inp);
		               
		                rs=ps.executeQuery();
		              int j=0;
		              rsm=rs.getMetaData();
		              j =rsm.getColumnCount(); 
		              
		              while(j!=0)
		              {
		               pw.print("<h1>"+rsm.getColumnName(j)+" |"+"</h1>");
		               j--;
		   
		              }
		       
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
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
    	}
    	
	}
	public DataSource getcon() throws Exception
	{
       InitialContext ic=null;
       ic=new InitialContext();
       DataSource ds=null;
       ds=(DataSource)ic.lookup("jdbc/comp/env/deep");
       System.out.println(ds);
       System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
      return ds;
	}

}
