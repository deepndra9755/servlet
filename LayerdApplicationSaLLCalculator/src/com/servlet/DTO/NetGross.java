package com.servlet.DTO;

import com.servlet.BO.BOCLASS;
import com.servlet.prectice.DAO.DatabaseConnectivey;

public class NetGross implements SallaryCalculator {

	String name=null,add=null,city=null,sallary=null,job=null,depart=null;
	BOCLASS bo=null;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAdd() {
		return add;
	}


	public void setAdd(String add) {
		this.add = add;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getSallary() {
		return sallary;
	}


	public void setSallary(String sallary) {
		this.sallary = sallary;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getDepart() {
		return depart;
	}


	public void setDepart(String depart) {
		this.depart = depart;
	}



	@Override
	public void calculate() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
