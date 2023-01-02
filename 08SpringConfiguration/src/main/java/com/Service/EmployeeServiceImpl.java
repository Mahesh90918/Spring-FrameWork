package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// dao a lots of child class i wont to pick only one that we go
	// @Qualifier Annotation and Class name

	@Autowired
	@Qualifier("employeeJdbcTempleteDaoImpl")

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
	@Override
	public List<Employee> findbyAll() {
		// TODO Auto-generated method stub
		return dao.findbyAll();
	}

}
