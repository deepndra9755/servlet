/*
 * checking person eligible for marrege or not 
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

public class MarryEligible extends HttpServlet {     //MarryEligible class opening
@Override
public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
{
	String name=null;
	String gender=null;
	int age=0;
PrintWriter pw=null;
pw=res.getWriter();
res.setContentType("text/html");
name=req.getParameter("name");
age=Integer.parseInt(req.getParameter("age"));
gender=req.getParameter("gender");

if(gender.equalsIgnoreCase("m")&age>21)
{
pw.println("<h1 style='color:red;text-align:center;'>"+" mr"+ name  +"you are eligible for massarage </h1>");
}

else if(gender.equalsIgnoreCase("f")&age>18)
{
	pw.println("<h1 style='color:red;text-align:center;'>"+"miss"+ name  +"you are eligible for maarage </h1>");
}
else
{
	pw.println("<h1 style='color:red;text-align:center;'>"+" "+ name  +"you are not eligible for maarage </h1>");
	}

//pw.println("<h1 style='color:red;text-align:center;'>"+"<a href='/home.htmt'>Visit W3Schools</a>"+"</h1>");
pw.println("<h1><a href='home.html'>home page</a></h1>");
//
}
@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter pw=resp.getWriter();
        resp.setContentType("text/html");
        pw.println(new Date());
        pw.println("<h1 style='text-align:center'"+new Date()+"</h1>");

        pw.println("<h1><a href='home.html'>home page</a></h1>");
	}
	/*
	 * @Override public void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { // TODO Auto-generated method
	 * stub PrintWriter pw=resp.getWriter(); resp.setContentType("text/html");
	 * pw.println("from service method which is occcurs"); }
	 */
}
