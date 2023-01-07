package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Employee;

@Repository
@Transactional
public class EmployeeHibernateTempleteDaoImpl implements EmployeeDao {
	@Autowired
	private HibernateTemplate hbmTem;

	@Override
	public void save(Employee employee) {
		hbmTem.save(employee);

	}

	@Override
	public void update(Employee employee) {
		hbmTem.update(employee);

	}

	@Override
	public void delete(Integer id) {
		Employee s = new Employee();
		s.setId(id);
		hbmTem.delete(s);

	}

	@Override
	public Employee findById(Integer id) {
		// find All one method get All
		return hbmTem.get(Employee.class, id);
	}

	@Override
	public List<Employee> findbyAll() {
		// find All one method Load All
		return hbmTem.loadAll(Employee.class);
	}


}
