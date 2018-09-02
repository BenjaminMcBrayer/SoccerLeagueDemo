<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://bootswatch.com/4/sandstone/bootstrap.css" media="screen">
<link rel="stylesheet"
	href="https://bootswatch.com/_assets/css/custom.min.css">
<title>TEAM MEMBERS</title>
</head>
<body>
	<div class="container">
		<input type="hidden" name="teamid" value="${team.teamid}">
	</div>
	<div class="container">
		<h3>Team Name</h3>
		${team.teamname}
	</div>

	<div class="container">
		<h3>Current Members</h3>
		<c:forEach var="member" items="${members}">
			${member}
			<br>
		</c:forEach>
	</div>
</body>
</html>