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
<h3>Add Product Details Here</h3>
<form method=post>
<table class="table">
<tr><th></th><th></th></tr>
<tr><td>product Id: </td><td><input type="text" name="prodId"></td></tr>
<tr><td>Name Of the Product:</td><td> <input type="text" name="productname"></td></tr>
<tr><td>Manufacturer/Brand: </td><td><input type="text" name="brandname"></td></tr>
<tr><td>Price:</td><td><input type="text" name="prodprice"></td></tr>
<tr><td>Product Type:</td><td><input type="text" name="prodtype"></td></tr>
<tr><td>Image Url:</td><td><input type="text" name="imageurl"></td><tr>
<tr><td>Product description:</td><td> <input type="text" name="prodfdesc"></td></tr>
</table>
<button type="submit" class="btn btn-success col-md-offset-2">Submit</button>
<a class="btn btn-primary col-md-2 col-md-offset-3" href="http://localhost:8090/mainapp/manageProducts">Go Back</a>
</form>
</div>
</body>
</html>