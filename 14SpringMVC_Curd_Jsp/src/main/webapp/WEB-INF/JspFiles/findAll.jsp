<%@page import="java.util.List"%>
<%@page import="com.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Find All</h1>
	<%-- 	<span style="color: green;">${employees}</span> < --%>
	<table border="1px">
		<tr>
			<td>Eid</td>
			<td>Ename</td>
			<td>Esal</td>
			<td>EMail</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>

		<%
			List<Employee> list = (List<Employee>) request.getAttribute("employees");
		%>
		
		<%
			for (Employee emp : list) {
		%>
		<tr>
			<td><%=emp.getId()%></td>
			<td><%=emp.getName()%></td>
			<td><%=emp.getSalary()%></td>
			<td><%=emp.getEmail()%></td>
			<td><a href="./updatebyId?Update_id=<%=emp.getId()%>">Update</a></td>
			<td><a href="./deleteEmp?Delete_id=<%=emp.getId()%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<button onclick="window.location.href = './addEmp';">New
		Employee</button>
	<br>
	<br>

	<a href="./home">HOME PAGE</a>
</body>
</html>