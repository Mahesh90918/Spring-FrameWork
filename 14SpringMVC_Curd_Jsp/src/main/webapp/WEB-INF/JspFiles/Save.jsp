<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./savemethod" method="post">
		<table align="center">
			<tr>
				<td>Eid:</td>
				<td><input type="text" name="id" placeholder="Enter eid"
					required="required"></td>
			</tr>

			<tr>
				<td>Ename:</td>
				<td><input type="text" name="name" placeholder="Enter name"
					required="required"></td>
			</tr>

			<tr>
				<td>Esal:</td>
				<td><input type="text" name="salary" placeholder="Enter salary"
					required="required"></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" placeholder="Enter Email"
					required="required"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="save"> <input
					type="reset" value="clear"></td>
			</tr>
		</table>
	</form>
	<button onclick="window.location.href = './home';">HOME PAGE
		</button>
	<br>
	<br>

</body>
</html>
