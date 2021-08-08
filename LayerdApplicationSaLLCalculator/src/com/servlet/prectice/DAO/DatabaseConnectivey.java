package com.servlet.prectice.DAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.servlet.DTO.NetGross;
import com.servlet.DTO.SallaryCalculator;

public interface DatabaseConnectivey {
	
	public int insert(NetGross obj)throws Exception;

}
