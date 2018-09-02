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
<title>Add Member</title>
</head>
<body>
	<div class="container">
		<h2>Add a New Member</h2>
		<form action="addmember">
			Name<br><input type="text" name="membername"></input><br>
			Role<br><input type="text" name="memberrole"></input><br>
			Team ID<br><input type="number" name="teamid"></input><br>
			<input type="submit" value="Submit"></input><br>
		</form>
	</div>
</body>
</html>