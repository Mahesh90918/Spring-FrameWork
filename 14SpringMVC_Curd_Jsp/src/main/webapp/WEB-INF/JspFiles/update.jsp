<%@page import="com.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Employee emp = (Employee) request.getAttribute("upemp");
	%>
	<form action="./updateEmpolyee" method="post">
		<table align="center">
			<tr>
				<td>Eid:</td>
				<%-- 				Same as like entity name or column name  "${upemp.id}" --%>
				<td><input type="text" name="id" value="<%= emp.getId() %>"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td>Ename:</td>
				<td><input type="text" name="name" value="<%= emp.getName() %>"></td>
			</tr>

			<tr>
				<td>Esal:</td>
				<td><input type="text" name="salary" value="<%= emp.getSalary() %>"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="<%= emp.getEmail() %>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"> <input
					type="reset" value="clear"></td>
			</tr>
		</table>
	</form>
	<button onclick="window.location.href = './addEmp';">New
		Employee</button>
	<br>
	<br>

	<a href="./home">HOME PAGE</a>
</body>
</html>