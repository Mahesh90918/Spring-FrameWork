package com.Queries;

public interface EmployeeQueries {
String FIND_BY_ID="SELECT * FROM EMPOLYEE WHERE ID=?";
String DELETE_BY_ID="DELETE FROM EMPOLYEE WHERE ID=?";
String INSERT_QUERY="insert into empolyee values(?,?,?,?)";
String UPDATE="update empolyee set name=?,salary=?,email=? where id=?";
}
