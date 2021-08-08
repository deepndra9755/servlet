package com.servlet.Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.DAO.MYSQLDEMO;
import com.servlet.DTO.DTOClss;
import com.servlet.VO.VOCls;

public class Monitor extends HttpServlet {
	MYSQLDEMO h1=null;
	DTOClss kkk=null;
    
  
   

	public void init()
	{
	kkk=new DTOClss();     //this is for vo initilization
	
	}
		  public Monitor()
		  {
		       h1=new MYSQLDEMO();
		  }


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter pw=null;
		 String name=null,des=null;
		 float sallary,basicsall,med,trasport,govtTax,gross,net;
		 name=request.getParameter("name");
		 sallary=Float.parseFloat(request.getParameter("sall"));
		des =request.getParameter("des");
		basicsall=Float.parseFloat(request.getParameter("basicsall"));
		 med=Float.parseFloat(request.getParameter("med"));
		 trasport=Float.parseFloat(request.getParameter("tl"));
		 govtTax=Float.parseFloat(request.getParameter("gtax"));
		 gross=Float.parseFloat(request.getParameter("grs"));
		 net=Float.parseFloat(request.getParameter("nt"));
		 pw=response.getWriter();
		 response.setContentType("text/html");
		 
		 h1.getcon();
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
