<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./updateEmpolyee" method="post">
		<table align="center">
			<tr>
				<td>Eid:</td>
				<%-- 				Same as like entity name or column name  "${upemp.id}" --%>
				<td><input type="text" name="id" value="${upemp.id}"
					readonly="readonly"></td>
			</tr>

			<tr>
				<td>Ename:</td>
				<td><input type="text" name="name" value="${upemp.name}"></td>
			</tr>

			<tr>
				<td>Esal:</td>
				<td><input type="text" name="salary" value="${upemp.salary}"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${upemp.email}"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"> <input
					type="reset" value="clear"></td>
			</tr>
		</table>
	</form>
	<a href="./addEmp">New Employee</a>
	<br>
	<br>

	<a href="./home">HOME PAGE</a>
</body>
</html>