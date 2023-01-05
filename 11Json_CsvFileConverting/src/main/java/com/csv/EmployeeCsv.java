package com.csv;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;
import com.hibernateConfig.HibernateConfiguration;
import com.opencsv.CSVWriter;

class EmployeeCsv {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");
		List<Employee> list = ec.findbyAll();
		try {
			CSVWriter csv1 = new CSVWriter(new FileWriter("src/main/java/com/csv/Employee.csv"));
		
			for (Employee employee : list) {
				String[] str = {String.valueOf(employee.getId()),employee.getName(),String.valueOf(employee.getSalary()),employee.getEmail() };
				csv1.writeNext(str);
			}

			csv1.flush();
			csv1.close();
			System.out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
