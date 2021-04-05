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
<h1>Welcome to Admin Home</h1>
<br/>
<h2>Choose from Following Options</h2>
<br/>
<h3>In Manage Products You can Update, Delete and Add any Product</h3>
<a class="btn btn-success" href="http://localhost:8090/mainapp/manageProducts" class="btn-group-lg">Manage Products</a>
<br/>
<h3>To See all Users who have Signed Up Click Below</h3>
<a class="btn btn-success" href="http://localhost:8090/mainapp/userDetails">See All Signed up Users</a>
<br/>
<h3>To See the quantity Of Items Which bought Click Below</h3>
<a class="btn btn-success" href="http://localhost:8090/mainapp/purchaseReport">See Purchase Reports</a>
</div>
</body>
</html>