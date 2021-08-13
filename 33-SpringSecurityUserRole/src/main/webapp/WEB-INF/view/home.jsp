<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>	
	<h2>Company Home Page</h2>
	<hr/>
	Welcome to company home page!
	<br>
	<div>
		User: <security:authentication property="principal.username"/>
		<br>
		Role(s): <security:authentication property="principal.authorities"/>
	</div>
	
	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<!--Link to point to /leaders -->
		<div>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip
				Meeting</a>
		</div>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<!--Link to point to /leaders -->
		<div>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a>
		</div>
	</security:authorize>

	<!--  Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="Submit" value="Logout"/>
	</form:form>
	
</body>
</html>