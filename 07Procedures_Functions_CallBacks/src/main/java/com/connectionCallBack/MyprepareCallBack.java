package com.connectionCallBack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

import com.bean.Employee;

public class MyprepareCallBack implements PreparedStatementCallback<Employee> {
	int eid;

	public MyprepareCallBack(int eid) {
		super();
		this.eid = eid;
	}

	public MyprepareCallBack() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
		ResultSet rs = ps.executeQuery();
		Employee emp = new Employee();
		while (rs.next()) {
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getDouble(3));
			emp.setEmail(rs.getString(4));
		}
		return emp;
	}

}
