package com.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Employee;
import com.dao.EmployeeDao;
import com.dao.EmployeeHibernateTempleteDaoImpl;

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
