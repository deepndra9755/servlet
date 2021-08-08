package com.servlet.prectice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Engine extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter pw=response.getWriter();
        response.setContentType("text/html");
        
        String nm=request.getParameter("nm");
        String name=request.getParameter("name");
        if(nm.equalsIgnoreCase("google"))
        {
        	
        	response.sendRedirect("https://www.google.com/search?client=firefox-b-d&q="+name);
        }
        else if(nm.equalsIgnoreCase("yahoo"))
        {
        	response.sendRedirect("https://in.search.yahoo.com/search?p="+name);
            
        	//https://in.search.yahoo.com/search?p
        }
        else if(nm.equalsIgnoreCase("duckduckgo"))
        {
        	
        	
        }
           //pw.println("https://www.google.com/search?sxsrf=");
        

		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
