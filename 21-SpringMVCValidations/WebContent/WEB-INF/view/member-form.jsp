<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member Form</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<form:form action="memberResult" modelAttribute="member">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><form:input path="surname" /></td>
				<td><form:errors path="surname" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Member Code</td>
				<td><form:input path="memberCode" /></td>
				<td><form:errors path="memberCode" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Role Code</td>
				<td><form:input path="roleCode" /></td>
				<td><form:errors path="roleCode" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>