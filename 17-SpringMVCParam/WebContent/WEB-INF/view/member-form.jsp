<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC - Param Passing</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<form action="memberResult" method="get">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="memberName"
					placeholder="Name" /></td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><input type="text" name="memberSurname"
					placeholder="Surname" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="memberAge"
					placeholder="Age" /></td>
			</tr>
		</table>
		<br>
		<input type="Submit">
	</form>
</body>
</html>