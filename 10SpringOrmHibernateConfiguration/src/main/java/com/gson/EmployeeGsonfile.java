package com.gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.bean.Employee;
import com.controller.EmployeeController;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.hibernateConfig.HibernateConfiguration;

@Component
public class EmployeeGsonfile implements GsonEmpolyeee {
	
	@Override
	public void GsonList(List<Employee> list, String location) {
		Gson gson = new Gson();
		try {
			PrintWriter file = new PrintWriter(location);
			for (Object obj : list) {
				gson.toJson(obj, file.append("\n"));
			}
			file.flush();
			file.close();
			System.out.println("success");
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void GsonSingle(Employee emp, String location) {
		Gson gson = new Gson();
		try {
			FileWriter file = new FileWriter(location);

			gson.toJson(emp, file);

			file.flush();
			file.close();
			System.out.println("success");
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");
		List<Employee> list = ec.findbyAll();
		EmployeeGsonfile gson = ac.getBean(EmployeeGsonfile.class);
		gson.GsonList(list, "src/main/java/com/gson/employee.gson");
		System.out.println("success");
	}

}
