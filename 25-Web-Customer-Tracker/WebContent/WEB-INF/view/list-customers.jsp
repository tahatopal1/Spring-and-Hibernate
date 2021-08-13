<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM- Customer Relationship Manager</h2>
		</div>
	</div>
	<div>
		<div>
			<input type="button" value="Add Customer"
				onclick="window.location.href = 'customer-form'; return false;" class="add-button"/>

			<table>
				<tr>
					<th>First Name</th>
					<th>First Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- Construct an "update" link with customer id -->
				<c:url var="updateLink" value="/customer/customer-form-update">
					<c:param name="customerID" value="${tempCustomer.id}"/>
				</c:url>

					<!-- Construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/customer-delete">
						<c:param name="customerID" value="${tempCustomer.id}" />
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!--  display the update link -->
							<a href="${updateLink}">Update</a> 
							|
							<!--  delete the customer -->
							<a href="${deleteLink}" onclick="if ((confirm('Are you sure you want to delete this customer?'))) return true;">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>