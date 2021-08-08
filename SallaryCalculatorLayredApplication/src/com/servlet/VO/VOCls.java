package com.servlet.VO;

import com.servlet.DTO.DTOClss;

public class VOCls {
	
	
	 String Ename=null,degi=null;
	 float sall,bsall,medi,trasportP,govtT,gros,nett;
	 DTOClss dto=null;
	 public VOCls()
	 {
	    dto=new DTOClss();
	 }
	 
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getDegi() {
		return degi;
	}
	public void setDegi(String degi) {
		this.degi = degi;
	}
	public float getSall() {
		return sall;
	}
	public void setSall(float sall) {
		this.sall = sall;
	}
	public float getBsall() {
		return bsall;
	}
	public void setBsall(float bsall) {
		this.bsall = bsall;
	}
	public float getMedi() {
		return medi;
	}
	public void setMedi(float medi) {
		this.medi = medi;
	}
	public float getTrasportP() {
		return trasportP;
	}
	public void setTrasportP(float trasportP) {
		this.trasportP = trasportP;
	}
	public float getGovtT() {
		return govtT;
	}
	public void setGovtT(float govtT) {
		this.govtT = govtT;
	}
	public float getGros() {
		return gros;
	}
	public void setGros(float gros) {
		this.gros = gros;
	}
	public float getNett() {
		return nett;
	}
	public void setNett(float nett) {
		this.nett = nett;
	}
	
	 
}
