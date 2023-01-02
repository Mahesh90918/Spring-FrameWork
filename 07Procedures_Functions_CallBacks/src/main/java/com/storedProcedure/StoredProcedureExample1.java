package com.storedProcedure;

import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.bean.Employee;

public class StoredProcedureExample1 extends StoredProcedure {

	public StoredProcedureExample1(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
		declareParameter(new SqlParameter("id", Types.INTEGER));

		declareParameter(new SqlOutParameter("name", Types.VARCHAR));
		declareParameter(new SqlOutParameter("salary", Types.INTEGER));
		declareParameter(new SqlOutParameter("email", Types.VARCHAR));
		compile();
	}

	public Employee execute1(Integer id) {
		Map<String, Object> out = super.execute(id);
		Employee student = new Employee();
		student.setId(id);
		student.setName((String) out.get("name"));
		student.setSalary((Integer) out.get("salary"));
		student.setEmail((String) out.get("email"));
		return student;
	}

}
