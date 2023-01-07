package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao empdao;

	@Override
	public void save(Employee employee) {
		empdao.save(employee);
	}

	@Override
	public void update(Employee employee) {
		empdao.update(employee);
	}

	@Override
	public void delete(Integer id) {
		empdao.delete(id);

	}

	@Override
	public Employee findById(Integer id) {
		return empdao.findById(id);
	}

	@Override
	public List<Employee> findbyAll() {
		return empdao.findbyAll();
	}

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeServiceImpl m = ac.getBean(EmployeeServiceImpl.class);
		System.out.println(ac);

	}

}
