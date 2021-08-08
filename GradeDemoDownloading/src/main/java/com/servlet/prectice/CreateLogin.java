package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;

public class CreateLogin extends HttpServlet {
	
	public static final String INSERT_USER="INSERT INTO EECUSTOMER (NAME,LAST,IMAGE,creationDate,PASSWORD) VALUES(?,?,?,?,?)";

	public void doGet(HttpServletRequest reqs, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ServletContext sc=null;
		sc=getServletContext();
		String sav=sc.getInitParameter("fol");
		java.sql.Date ghh=null;
		
		
		SimpleDateFormat formDate = new SimpleDateFormat("dd-mm-yy");

	       // String strDate = formDate.format(System.currentTimeMillis()); // option 1
	       String strDate = formDate.format(new Date()); // option 2
	       
	      java.util.Date gh=null;
		try {
			gh =formDate.parse(strDate);
			 ghh=CreateLogin.tim(gh);
			
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DataSource ds=null;
		 Connection con=null;
		 PreparedStatement ps=null;
		 String name=null,last=null,image=null,pass=null,dat=null;
		 MultipartFormDataRequest req=null;
		 String jop=null;
		 try {
			
			 req=new MultipartFormDataRequest(reqs);
			 name= req.getParameter("name");
			 last=req.getParameter("last");
//			 image=req.getParameter("image");
			 UploadBean upll=null;
			 upll=new UploadBean();
			 upll.setFolderstore(sav);
			 upll.setOverwrite(false);
			 upll.store(req,"image");
			 
			 Hashtable g=req.getFiles();
			 
			 jop=((UploadFile)g.get("image")).getFileName();
			 
			 
			 
			 pass=req.getParameter("pass");
		} 
		 catch (UploadException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		  

		try {
			 ds=DataSourceConn.conn();
			  con =ds.getConnection();
			  ps=con.prepareStatement(INSERT_USER);
			  ps.setString(1,name);
			  ps.setString(2,last);
			  ps.setString(3,sc.getInitParameter("fol")+jop);
			 ps.setDate(4,ghh);
			  ps.setString(5,pass);
			  
			  int count=ps.executeUpdate();
			  if(count==0)
			  {
			pw.println("some thing wrong");	  
			  }
			  else 
				  
				  pw.println("inserted");	
			  
		} 
		catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static java.sql.Date tim(java.util.Date k)
	{
		
   java.sql.Date h=new java.sql.Date(k.getTime());	
   return h;
	}

}
