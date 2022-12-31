package com.HasA.bean;

public class Employee {
	int eid;
	String ename;
	double esal;
	Address eaddress;

	public Employee(int eid, String ename, double esal, Address eaddress) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.eaddress = eaddress;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", eaddress=" + eaddress + "]";
	}

}
