package com.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;
import com.hibernateConfig.HibernateConfiguration;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class EmployeePdf {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");
		List<Employee> list = ec.findbyAll();
		Document doc = new Document();

		try {
			PdfWriter pw = PdfWriter.getInstance(doc, new FileOutputStream("src/main/java/com/pdf/Employee.pdf"));
			for (Employee employee : list) {
//			doc.add(employee.getId());
			}
			pw.flush();
			pw.close();
			System.out.println("success");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
