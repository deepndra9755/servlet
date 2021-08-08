package com.servlet.Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.DTO.NetGross;
import com.servlet.DTO.SallaryCalculator;
import com.servlet.VO.VOINTERN;
import com.servlet.VO.VoImpplementCls;
import com.servlet.prectice.DAO.DatabaseConnectivey;
import com.servlet.prectice.DAO.MYSQL;

public class Controller extends HttpServlet {
	DatabaseConnectivey mysqlCls=null;
	//VoImpplementCls vo;
	NetGross vo=null;
	


public void init() throws ServletException {
	
	mysqlCls=new MYSQL();                                   
	
    }
public Controller() 
{
 vo=new NetGross();
}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=res.getWriter();
	    String name=null,add=null,city=null,sallary=null,job=null,depart=null;
		  name=req.getParameter("name");
	     add= req.getParameter("add");
	     city= req.getParameter("ct");
	      sallary=req.getParameter("sall");
	      job=req.getParameter("job");
	      depart=req.getParameter("depart");
	      vo.setName(name);
	      vo.setCity(city);
	      vo.setSallary(sallary);
	      vo.setAdd(add);
	      vo.setJob(job);
	      vo.setDepart(depart);
	      
	      try {
			int count=mysqlCls.insert(vo);
			if(count==0)
			{
			pw.println("<h1>not inserted</h1>");
			}
			else{
				pw.println("<h1>inserted</h1>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      
	      
	      //mysqlCls.cal();
	     	 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
