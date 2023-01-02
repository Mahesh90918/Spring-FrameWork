package com.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.bean.Employee;
import com.connectionCallBack.MyConnectionCallback;
import com.connectionCallBack.MyprepareCallBack;
import com.storedProcedure.StoredProcedureExample;
import com.storedProcedure.StoredProcedureExample1;

@Service
public class EmployeeJdbcTempleteDaoImpl implements EmployeeDao {
	@Autowired
	JdbcTemplate jdbctem;

	@Override
	public Map<String, Integer> execute(Integer num1, Integer num2) {
		return new StoredProcedureExample(jdbctem, "addd").execute(num1, num2);
	}

	public Employee getEmployee(Integer id) {
		StoredProcedureExample1 studentProcedure = new StoredProcedureExample1(jdbctem, "getempolyee");
		return studentProcedure.execute1(id);
	}

	public Employee findbyId_CallBack(Integer id) {
		return jdbctem.execute(new MyConnectionCallback(id));
	}
	public Employee findbyId_prepareCallBack(Integer id) {
		return jdbctem.execute("select * from empolyee where id="+id, new MyprepareCallBack());
	}
	
	  public Employee getEmployee_Function(Integer id) {
	      SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbctem).withFunctionName("get_student_name");
	      SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
	      String name = jdbcCall.executeFunction(String.class, in);
	      Employee student = new Employee();
	      student.setId(id);
	      student.setName(name);
	      return student;      
	   }

}
