package com.test.RemaingMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.bean.Employee;

public class BatchUpdateExample {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		JdbcTemplate jdbc = (JdbcTemplate) ac.getBean("jdbc_temp");
//		int[] a = jdbc.batchUpdate("INSERT INTO EMPOLYEE VALUES(14,'A',123,'abc@bcd')", "delete from empolyee where id between 10 and 20");
//		System.out.println(Arrays.toString(a));
//		int [] b=jdbc.batchUpdate("update empolyee set name='siva' where id between 1 and 4");
//		System.out.println(Arrays.toString(b));

		int[] c = jdbc.batchUpdate("update empolyee set name=? where id between ? and ?",
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						ps.setString(1, "mahesh");
						ps.setInt(2, 5);
						ps.setInt(3, 7);
					}

					@Override
					public int getBatchSize() {
						return 1;
					}
				});
		System.out.println(Arrays.toString(c));

	}
}
