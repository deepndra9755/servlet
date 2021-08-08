package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;


public class FileUploadingDemo extends HttpServlet {
	public static final String qrry="insert into dumm(name,resume,image) values(?,?,?)";
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MultipartFormDataRequest req=null;
	UploadBean up=null;
	 Connection con=null;
	 PreparedStatement ps=null;
	 ServletContext sc=null;
	 String nmm;
	 
	 
	
	DataSource dd=null;
	String f=null,f1=null;
	try {
		req=new MultipartFormDataRequest(request);
		up=new UploadBean();
		PrintWriter pd=response.getWriter();
		response.setContentType("text/html");
	    up.setFolderstore("D:/myserve");
		up.setOverwrite(false);
		nmm=req.getParameter("name");
		up.store(req,"img");
		up.store(req,"resm");
		Hashtable has=req.getFiles();
	   f=((UploadFile)has.get("resm")).getFileName();
	   f1=((UploadFile)has.get("img")).getFileName();
	  // pd.println(has);
	   sc=getServletContext();
	   
	   
	   // Enumeration<UploadFile> j=has.elements();
//        while(j.hasMoreElements())	
//        {
//        has.get(j.nextElement().
//        }
//		pd.println(f);
//		pd.println(f1);
    
	      DataSource jjjj=getconn();
	      
	      con = jjjj.getConnection();
	      
	      PreparedStatement pp=con.prepareStatement(qrry);
	      pp.setString(1,nmm);
	      pp.setString(2,sc.getInitParameter("direct")+f);
	      pp.setString(3,sc.getInitParameter("direct")+f1);
	     int countt=pp.executeUpdate();
	     if(countt==0)
	     {
	    	pd.println("not inserted"); 
	     }
	     else
	    	 pd.println("inserted");
	         Enumeration<UploadFile> op=has.elements();
	         while(op.hasMoreElements())
	         {
	        	 String j=((UploadFile)has.get(sc.getInitParameter("direct")+"resm")).getFileName();
	           	 pd.println(j);
	           	String je=((UploadFile)has.get(sc.getInitParameter("direct")+"img")).getFileName();
	       	 pd.println(je);
	         }
		
	    
	 	
		
	} catch (UploadException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	private DataSource getconn() throws NamingException
	{
		DataSource fgh=null;
		InitialContext ic=null;
		ic=new InitialContext();
		return (DataSource)ic.lookup("java:/comp/env/dsjndi");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
