package com.connectionCallBack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ConnectionCallback;

import com.bean.Employee;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

public class MyConnectionCallback implements ConnectionCallback<Employee> {
	int eid;

	public MyConnectionCallback(int eid) {
		super();
		this.eid = eid;
	}

	@Override
	public Employee doInConnection(Connection con) throws SQLException, DataAccessException {
		PreparedStatement ps = con.prepareStatement("select * from empolyee where id=?");
		ps.setInt(1, eid);
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
