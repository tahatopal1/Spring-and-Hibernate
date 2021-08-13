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
	width: 50%;
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
	<table>
		<tr>
			<td>Name</td>
			<td>${param.memberName}</td>
		</tr>
		<tr>
			<td>Surname</td>
			<td>${param.memberSurname}</td>

		</tr>
		<tr>
			<td>Age</td>
			<td>${param.memberAge}</td>
		</tr>
	</table>
</body>
</html>