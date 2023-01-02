package com.storedProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.bean.Employee;

public class StoredProcedureExample extends StoredProcedure {

	public StoredProcedureExample(JdbcTemplate jdbcTemplate, String name) {
		super(jdbcTemplate, name);
		declareParameter(new SqlParameter("num1", Types.INTEGER));
		declareParameter(new SqlParameter("num2", Types.INTEGER));
		declareParameter(new SqlOutParameter("result", Types.INTEGER));
		compile();
	}

	public Map<String, Integer> execute(int num1, int num2) {
		Map<String, Integer> resultsmap = new HashMap<>();
		Map<String, Object> map = super.execute(num1, num2);
		resultsmap.put("Final Result", (Integer) map.get("result"));
		return resultsmap;
	}

	

}
