package com.csv;

import java.util.ArrayList;
import java.util.List;

import com.bean.Employee;

public class Sarada {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(01, "mahesh", 1234, "SDFGH"));
		list.add(new Employee(02, "mahesh", 1234, "SDFGH"));
		list.add(new Employee(03, "mahesh", 1234, "SDFGH"));
		System.out.println(list);
		
		for (Employee employee : list) {
			String s=employee.toString();
			System.out.println(s);
		}

		
	}
}
