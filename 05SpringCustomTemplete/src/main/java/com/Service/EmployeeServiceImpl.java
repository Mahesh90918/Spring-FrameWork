package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.dao.EmployeedaoImpl;
//we can use this annotation in Service Layer

@Service("empServImpl")
public class EmployeeServiceImpl implements EmployeeService {
// normal way
//	EmployeeDao dao = new EmployeedaoImpl();
	// this object creating Spring

	@Autowired
	// dao a lots of child class i wont to pick only one that we go
	// @Qualifier Annotation and Class name

	@Qualifier("employeeCustomTempleteDaoImpl")

//	@Qualifier("employeedaoImpl")
	EmployeeDao dao;

	@Override
	public void save(Employee employee) {
		System.out.println("EmployeeServiceImpl Save Method");
		dao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		System.out.println("EmployeeServiceImpl Update Method");
		dao.update(employee);

	}

	@Override
	public void delete(Integer id) {
		System.out.println("EmployeeServiceImpl delete Method");
		dao.delete(id);

	}

	@Override
	public Employee findById(Integer id) {
		System.out.println("EmployeeServiceImpl findById Method");

		return dao.findById(id);
	}

}
