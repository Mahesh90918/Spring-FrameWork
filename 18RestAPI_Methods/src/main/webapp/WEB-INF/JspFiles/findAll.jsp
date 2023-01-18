<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Find All</h1>
	<span style="color: green;">${saveMsg}</span>

	<table border="1px">
		<tr>
			<td>Eid</td>
			<td>Ename</td>
			<td>Esalary</td>
			<td>Email</td>
			<td>Update</td>
			<td>Delete</td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.id}"></c:out></td>
				<td><c:out value="${employee.name}"></c:out></td>
				<td><c:out value="${employee.salary}"></c:out></td>
				<td><c:out value="${employee.email}"></c:out></td>
				<td><a href="./updatebyId?Update_id=${employee.id}">Update</a></td>
				<td><a href="./deleteEmp?Delete_id=${employee.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	
	<a href="./addEmp">New Employee</a>
	<br>
	<br>
	
	<a href="./home">HOME PAGE</a>
</body>
</html>