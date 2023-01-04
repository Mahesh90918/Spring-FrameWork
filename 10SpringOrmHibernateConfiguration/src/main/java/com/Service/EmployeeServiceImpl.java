package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Repository
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empdao;

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		empdao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		empdao.update(employee);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		empdao.delete(id);

	}

	@Override
	public Employee findById(Integer id) {
		// TODO Auto-generated method stub
		return empdao.findById(id);
	}

	@Override
	public List<Employee> findbyAll() {
		// TODO Auto-generated method stub
		return empdao.findbyAll();
	}

}
