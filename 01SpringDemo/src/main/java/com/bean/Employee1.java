package com.bean;

public class Employee1 {
	int sid;
	String sname;
	double sfee;

	public Employee1() {
		System.out.println("default constructor Employee1");
	}
     
	@Override
	public String toString() {
		return "Employee1 [sid=" + sid + ", sname=" + sname + ", sfee=" + sfee + "]";
	}

}
