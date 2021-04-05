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
<h1>Admin User Login</h1>
<form method="post" class="form">
<h4>User Name :</h4><input type="text" class="form-control" name="adminName">
<br/>
<h4>Password :</h4><input type="password" class="form-control" name="adminPassword">
<br/>
<button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Login</button>
</form>
</div>
<script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>