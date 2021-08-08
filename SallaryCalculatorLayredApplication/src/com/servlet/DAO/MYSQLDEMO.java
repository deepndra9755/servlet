package com.servlet.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MYSQLDEMO implements DataConnectio {
	
	
	public static final String qry="INSERT INTO DUMMY(NAME,TITLE,SALLARY,BASICSALL,MEDICAL,TRANSPORT,GOVTTAX,GROSS,NET) VALUES(?,?,?,?,?,?,?,?,?)";
	
	public void insert()throws Exception
	{
		 Connection con=null;
		 PreparedStatement ps=null;
	     DataSource ds=getcon();
	     con=ds.getConnection();
	     PreparedStatement pss=con.prepareStatement(qry);
	     pss.setString(1,name);
	     
	}
public DataSource getcon() throws Exception
{
   InitialContext ic=null;
   ic=new InitialContext();
   DataSource ds=null;
   ds=(DataSource)ic.lookup("jdbc/comp/env/deep");
  // System.out.println(ds);
   //System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
  return ds;
}


}
