package com.springConfig;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "com")
@PropertySource(value = {"classpath:db.properties"})
public class SpringConfig {
	
	{
		System.out.println("SpringConfig Test");
	}
	
// property File reading  Environment
	@Autowired
	Environment environment;
	
	// this is DataSource bean
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource basic = new BasicDataSource();
		basic.setDriverClassName(environment.getProperty("mysql.driver"));
		basic.setUrl(environment.getProperty("mysql.url"));
		basic.setUsername(environment.getProperty("mysql.uname"));
		basic.setPassword(environment.getProperty("mysql.pwd"));
		return basic;
	}
	// 2 way
//	@Bean
//	public DataSource dataSource1() {
//		BasicDataSource basic = new BasicDataSource();
//		basic.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		basic.setUrl("jdbc:mysql://localhost:3306/jdbcdemo");
//		basic.setUsername("root");
//		basic.setPassword("root");
//		return basic;
//	}

	// this is JdbcTemplate bean
	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource());
		return jdbc;
	}
	
}

// this property file configuration Like that
/*
 * <context:annotation-config></context:annotation-config>
 * 
 * <context:component-scan base-package="com"></context:component-scan>
 * 
 * <context:property-placeholder location="classpath:db.properties" />
 * 
 * <bean id="dataSource_DBCP" class="org.apache.commons.dbcp.BasicDataSource">
 * <property name="url" value="${url}"></property> <property name="username"
 * value="${userName}"></property> <property name="password"
 * value="${pwd}"></property> <property name="driverClassName"
 * value="${driverName}"></property> </bean>
 * 
 * <!-- Spring jdbcTemplete -->
 *  <bean id="jdbc_temp"
 * class="org.springframework.jdbc.core.JdbcTemplate"> <property
 * name="dataSource" ref="dataSource_DBCP"></property> </bean>
 */