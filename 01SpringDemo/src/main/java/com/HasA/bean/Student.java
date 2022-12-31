package com.HasA.bean;

public class Student {
	int sid;
	String sname;
	double sfee;
	Address saddress;
	// Setter injection

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getSfee() {
		return sfee;
	}

	public void setSfee(double sfee) {
		this.sfee = sfee;
	}

	public Address getSaddress() {
		return saddress;
	}

	public void setSaddress(Address saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sfee=" + sfee + ", saddress=" + saddress + "]";
	}

}
