package com.servlet.prectice.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import com.servlet.DTO.NetGross;
import com.servlet.DTO.SallaryCalculator;

public class MYSQL implements DatabaseConnectivey{


	
public static final String INsert_Student="INSERT INTO CIVIL (NAME,ADDRESS,CITY,SALLARY,JOB,DEPARTMENT) VALUES(?,?,?,?,?,?) ";
	
	public int insert(NetGross obj) throws Exception
	{
	                 DataSource dc=MYSQL.jndi();
	                 Connection con=dc.getConnection();
	                 PreparedStatement ps=con.prepareStatement(INsert_Student);
	                 ps.setString(1,obj.getName());
	                 ps.setString(2,obj.getAdd());
	                 ps.setString(3,obj.getCity());
	                 float g=Float.parseFloat(obj.getSallary());
	                 ps.setFloat(4,g);
	                
	                 ps.setString(5,obj.getJob());
	                 ps.setString(6,obj.getDepart());
	                 
	                return ps.executeUpdate();
	                
	                 
	                 
	               
	}
	public static DataSource jndi() throws NamingException
	{
		
	   InitialContext ic=null;
	   ic=new InitialContext();
	   return(DataSource)ic.lookup("java:/comp/env/dsjndi");
	}


}
