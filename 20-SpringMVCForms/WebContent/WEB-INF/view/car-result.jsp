<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Forms</title>
</head>
<body>
	<h3>Car Result Page</h3>
	<hr />
	Brand: ${car.brand}
	<br /> Submodel: ${car.subModel}
	<br /> Type: ${car.type}
	<br /> Assurance: ${car.assuranceType}
	<br /> Color: ${car.color}
	<br /> Motor: ${car.motor}
	<br /> Year: ${car.year}
	<br />

	<ul>
		<c:forEach var="var" items="${car.additions}">
			<li> ${var} </li>
		</c:forEach>
	</ul>

</body>
</html>