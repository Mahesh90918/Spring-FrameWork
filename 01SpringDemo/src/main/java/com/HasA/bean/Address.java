package com.HasA.bean;

public class Address {
	int id;
	String location;
	long pincode;





	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public long getPincode() {
		return pincode;
	}



	public void setPincode(long pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", location=" + location + ", pincode=" + pincode + "]";
	}

}
