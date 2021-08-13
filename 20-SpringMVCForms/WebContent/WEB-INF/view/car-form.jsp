<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Forms</title>
</head>
<body>
	<h3>Car Form Page</h3>
	<hr />
	<form:form action="carResult" modelAttribute="car">
		<table>
			<tr>
				<td>Brand:</td>
				<td><form:input path="brand" /></td>
			</tr>
			<tr>
				<td>SubModel:</td>
				<td><form:input path="subModel" /></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><form:select path="type">
						<form:option value="Sedan" label="Sedan" />
						<form:option value="Hatchback" label="Hatchback" />
						<form:option value="StationWagon" label="StationWagon" />
					</form:select></td>
			</tr>
			<tr>
				<td>Assurance:</td>
				<td><form:select path="assuranceType">
						<form:options items="${car.assuranceTypes}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Color:</td>
				<td><form:select path="color">
						<form:options items="${colors}" />
					</form:select></td>
			</tr>
			<tr>
				<td>Motor:</td>
				<td>1.25 <form:radiobutton path="motor" value="1.25" /> 1.3 <form:radiobutton
						path="motor" value="1.3" /> 1.4 <form:radiobutton path="motor"
						value="1.4" /></td>
			</tr>
			<tr>
				<td>Year:</td>
				<td><form:radiobuttons path="year" items="${car.years}" /></td>
			</tr>
			<tr>
				<td>Additions:</td>
				<td><form:checkbox path="additions" label="automatic transmission" value="automatic transmission"/>
					<form:checkbox path="additions" label="steel rim" value="steel rim"/>
					<form:checkbox path="additions" label="sunroof" value="sunroof"/> 
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="Submit" style="width: 100%" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>