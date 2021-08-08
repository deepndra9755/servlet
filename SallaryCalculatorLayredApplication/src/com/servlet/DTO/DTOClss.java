package com.servlet.DTO;

import java.io.Serializable;

import com.servlet.BO.BOCLs;

public class DTOClss implements Serializable {
	BOCLs bofs=null;
	public DTOClss()
	{
		bofs=new BOCLs();                       
	}
	
}
