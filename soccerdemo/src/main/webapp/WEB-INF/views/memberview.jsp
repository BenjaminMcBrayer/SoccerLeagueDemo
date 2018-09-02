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
<title>${title}</title>
</head>
<body>
	<div class="container">
		<h3>Member Information</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>Team</th>
					<th>Role</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>${member.membername}</td>
						<td>${member.team.teamname}</td>
						<td>${member.memberrole}</td>
					</tr>
			</tbody>
		</table>
	</div>
</body>
</html>