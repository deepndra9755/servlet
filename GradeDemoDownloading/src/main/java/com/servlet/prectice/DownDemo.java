package com.servlet.prectice;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;


public class DownDemo extends HttpServlet {
	//PrintWriter sos=null;
	
    public static final String serach_custum="SELECT NAME,LAST,IMAGE FROM EECUSTOMER WHERE NAME=?";

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	         //sos=res.getOutputStream();
		//ServletOutputStream sos=null;
	         //sos=res.getOutputStream();
	         ServletOutputStream sos=null;
	         sos=res.getOutputStream();
	     
	         String typ=null;
	         String val=null;
	          typ=req.getParameter("submitt");
	         if(typ!=null)
	         if(typ.equalsIgnoreCase("forr"))
	         {
	       sos.println("<table width=100% height=30 style='background-color: blue;'>");
	       sos.println("<td><th><h2 style='color:white'>name</th><th><h2 style='color:white'>last</th><th><h2 style='color:white'></th><th><h2 style='color:white'>resume</th></td>");
	       sos.println("</table>");
	        	    
	         }
	         else if(typ.equalsIgnoreCase("search"))
	         {
	           val=req.getParameter("serach");
	           try {
				DataSource dg=DataSourceConn.conn();
				Connection cn=dg.getConnection();
				PreparedStatement puo=cn.prepareStatement(serach_custum);
				puo.setString(1, val);
				ResultSet rss=puo.executeQuery();
				//sos.println("<head><h1 style='color:white'>name</h1>&nbsp();&nbsp();<h1 style='color:white'>last</h1>&nbsp();&nbsp();<h1 style='color:white'>image</h1></head>");
				
                sos.println("<table width=100% height=30 style='background-color:blue;'>");
            		sos.print("<th style='color:white'>name</th><th style='color:white'>last</th><th style='color:white'>image</th>");
//				 
				while(rss.next())
				{
					
				  sos.println("<tr style='background-color: white;'><td>"+rss.getString(1)+" | "+rss.getString(2)+" | "+"<a href=pop?submitt=dhol&sub="+rss.getString(3)+">download"+"<img src="+rss.getString(3)+"</h3></td></tr>"); 
				  //sos.println("");
				}
			
				sos.println("</table>"); 
		     	} 
	         
	           catch (NamingException e)
	           {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) 
	           {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }
	         }
	           else if(typ.equalsIgnoreCase("dhol"))
	           {
	        	  //System.out.println("this is from sub");
	        	  sos.print("from last else");  
	        	  
	        	 String jop= req.getParameter("sub");
	        	  java.io.File fos=new java.io.File(jop);
	       sos.print(fos.getAbsoluteFile().getName());
	        	  InputStream ioo=new FileInputStream(fos);
	        	  ServletContext sc=getServletContext();
	        	 // System.out.println("mime type"+);
	        	  //System.out.println("name of file"+);
	        	  System.out.println();
	        	  System.out.println();
	        	  res.setContentType(sc.getMimeType(jop));
	        	  res.setHeader("Content-Disposition", "attachment;filename="+fos.getName());	        	
	        	  IOUtils.copy(ioo, sos);
	        	  
	           }
	           
	         }
	     
	         
		  
		  
		  


	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
