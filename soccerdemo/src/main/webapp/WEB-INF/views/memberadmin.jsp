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
<title>MEMBERS</title>
</head>
<body>
	<div class="container">
		<h3>List of Current Members</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Name</th>
					<th>View</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${members}">
					<tr>
						<td>${member.membername}</td>
						<td><a href="/viewmember/${member.memberid}">View</a>
						<td><a href="editmember?memberid=${member.memberid}">Edit</a>
						<td><a href="deletemember?memberid=${member.memberid}"
							onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	<div class="container">
		<a href="addnewmember?memberid=${member.memberid}">Add a New Member</a>
	</div>
	</div>
</body>
</html>