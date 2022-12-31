package com.bean;

public class Employee2 {
	int eid;
	String ename;
	double efee;

	public Employee2(int eid) {
		super();
		this.eid = eid;
	}

	public Employee2(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}

	public Employee2(int eid, double efee) {
		super();
		this.eid = eid;
		this.efee = efee;
	}

	@Override
	public String toString() {
		return "Employee2 [eid=" + eid + ", ename=" + ename + ", efee=" + efee + "]";
	}

}
