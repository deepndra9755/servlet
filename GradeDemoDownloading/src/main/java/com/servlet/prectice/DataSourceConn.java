package com.servlet.prectice;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceConn {
	
	public static DataSource conn() throws NamingException
	{
	   InitialContext ic=null;
	   
	   ic=new InitialContext();
	   return(DataSource)ic.lookup("java:/comp/env/dsjndi");
	}

}
