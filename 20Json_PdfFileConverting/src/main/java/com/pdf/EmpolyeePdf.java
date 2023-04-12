package com.pdf;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Service.EmployeeService;
import com.bean.Employee;
import com.controller.EmployeeController;
import com.hibernateConfig.HibernateConfiguration;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class EmpolyeePdf {

	private static void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.BLUE);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Empolyee ID", font));

		table.addCell(cell);

		cell.setPhrase(new Phrase("Empolyee Name", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Empolyee Salary", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Empolyee Email", font));
		table.addCell(cell);

	}

	private static void writeTableData(PdfPTable table) {

	}

	public static void main(String[] args) throws DocumentException, FileNotFoundException {

		ApplicationContext ac = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");
		List<Employee> list = ec.findbyAll();
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, new FileOutputStream("src/main/java/com/pdf/Employee11.pdf"));

		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);

		Paragraph p = new Paragraph("List of Users", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 3.5f, 3.0f, 3.0f});
		table.setSpacingBefore(10);

		writeTableHeader(table);
		for (Employee user : list) {
			table.addCell(String.valueOf(user.getId()));
			table.addCell(user.getName());
			table.addCell(String.valueOf(user.getSalary()));
			table.addCell(user.getEmail());
		}

		document.add(table);
		System.out.println("Success");
		document.close();
	}
}
