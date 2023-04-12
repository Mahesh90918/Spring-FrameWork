package com.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Service.EmployeeServiceImpl;
import com.bean.Employee;

@Repository
@Transactional
public class EmployeeHibernateTempleteDaoImpl implements EmployeeDao {
	static Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private HibernateTemplate hbmTem;

	@Override
	public void save(Employee employee) {
		log.info("EmployeeDaoImpl  save STARTING............");
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
