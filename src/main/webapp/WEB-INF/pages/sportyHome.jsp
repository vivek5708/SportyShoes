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
	<h1>Following Products are Available at our Store</h1>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>imageUrl</th>
				<th>Name</th>
				<th>price</th>
				<th>Brand</th>
				<th>Product Type</th>
				<th>Product Description</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${footwears}" var="fw">
			<tr>
				<td><img width=35% height=auto class="img-thumbnail" src="${fw.getImageUrl() }"></td>
				<td>${fw.getName()}</td>
				<td>${fw.getPrice()}</td>
				<td>${fw.getBrand()}</td>
				<td>${fw.getProductType()}</td>
				<td>${fw.getProductDesc()}</td>
				<td><a type="button" class="btn btn-warning"
						href="http://localhost:8090/mainapp/buyProduct?id=${fw.id}">Buy</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-primary col-md-2 col-md-offset-5" href="http://localhost:8090/mainapp/welcome">Go Back</a>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>