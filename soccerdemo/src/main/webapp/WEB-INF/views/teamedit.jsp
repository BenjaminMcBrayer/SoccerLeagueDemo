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
<title>Edit Team</title>
</head>
<body>
<h2> Update a Team</h2>	
<form action="teamedit">
		<input type="hidden" name="teamid" value="${team.teamid}">
		<table>
			<tr>
				<td>Team ID</td>
				<td>${team.teamid}</td>
			</tr>
			<tr>
				<td>Team Name</td>
				<td><input type="text" name="teamname" value="${team.teamname}"></input></td>
			</tr>
		</table>
		<input id="submitBtn" type="submit" value="Update"></input>
	</form>
</body>
</html>