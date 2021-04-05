<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes.com</title>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<div style="margin: auto; width: 60%; padding: 10px;">
<h2>Following are the Users who Signed Up</h2>
	<form method="post">
			<div class="col-md-9">
				<input class="form-control" type="text" name="username" placeholder="User Name">
			</div>
			<div class="col-md-3">
				<button type="submit" class="btn btn-success">Search</button>
			</div>
	</form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Id</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${searchedUser}" var="su">
			<tr>
				<td>${su.getFirstName()}</td>
				<td>${su.getLastName()}</td>
				<td>${su.getEmail()}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-primary col-md-2 col-md-offset-5" href="http://localhost:8090/mainapp/adminHome">Go Back</a>
</div>
</body>
</html>