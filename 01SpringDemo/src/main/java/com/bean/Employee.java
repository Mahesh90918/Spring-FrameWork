package com.bean;

public class Employee {
	int sid;
	String sname;
	double sfee;

	public Employee(int sid, String sname, double sfee) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sfee = sfee;
		System.out.println("Constructor with param Employee");
	}

	@Override
	public String toString() {
		return "Employee [sid=" + sid + ", sname=" + sname + ", sfee=" + sfee + "]";
	}

}
