package com.dao;

import java.util.Map;

import com.bean.Employee;

public interface EmployeeDao {
// add method using Stored procedure name (ADDD)
	Map<String, Integer> execute(Integer num1, Integer num2);

// get by id employee details
	Employee getEmployee(Integer id);

//	 ConnectionCallBack interface
	Employee findbyId_CallBack(Integer id);

//	 preparedStatement CallBack
	Employee findbyId_prepareCallBack(Integer id);

//      Stored function
	Employee getEmployee_Function(Integer id);
}
