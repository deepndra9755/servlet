/*
 * calculating sum mul add div using multi botton and link
 * team :- indivisual
 * version :- 1.0
 */
package com.servlet.prectice;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
//package creation
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//package importing

public class BottonLinkTogether extends HttpServlet {     //BottonLinkTogether class opening
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
{
	String n1=null;
	String n2=null;
	int age=0;
PrintWriter pw=null;
pw=res.getWriter();
res.setContentType("text/html");
n1=req.getParameter("bott");
int j=0;
int j1=0;
if(!n1.equalsIgnoreCase("t")&&!n1.equalsIgnoreCase("d"))
{
	 j=Integer.parseInt(req.getParameter("num1"));
	 j1=Integer.parseInt(req.getParameter("num2"));  
	 if(n1.equalsIgnoreCase("sum"))
	 {
		 int j2=j+j1;
		 pw.println("<h1>"+j2+"</h1>");
		 }
	 else if(n1.equalsIgnoreCase("mul"))
	 {
	 	int j2=j*j1;
	 	pw.println("<h1>"+j2+"</h1>");	
	 }
	 else if(n1.equalsIgnoreCase("sub"))
	 {
	 	int j2=j-j1;
	 	pw.println("<h1>"+j2+"</h1>");	
	 }
	 else if(n1.equalsIgnoreCase("div"))
	 {
	 	int j2=j/j1;
	 	pw.println("<h1>"+j2+"</h1>");	
	 }
	
	
}
else if (n1.equalsIgnoreCase("d"))
{
	pw.println("<h1>"+new Date()+"</h1>");
}

else if (n1.equalsIgnoreCase("t"))
{
pw.println("<h1>today date will be</h1>");	
}




}
@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
          doPost(req, resp);
	}
	/*
	 * @Override public void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { // TODO Auto-generated method
	 * stub PrintWriter pw=resp.getWriter(); resp.setContentType("text/html");
	 * pw.println("from service method which is occcurs"); }
	 */
}
