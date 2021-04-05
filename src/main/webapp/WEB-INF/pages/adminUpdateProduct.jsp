<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SportyShoes.com</title>
</head>
<link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<body>
<div style="margin: auto; width: 60%; padding: 10px;">
<h1>Update the Product</h1>
<form method="post">
<h4>Name :</h4><input type="text" class="form-control" placeholder="${footwearObj.getName()}" name="prodName">
<br/>
<h4>Brand :</h4><input type="text" class="form-control" placeholder="${footwearObj.getBrand()}" name="prodBrand">
<br/>
<h4>Price :</h4><input type="text" class="form-control" placeholder="${footwearObj.getPrice()}" name="prodPrice">
<br/>
<h4>productType:</h4><input type="text" class="form-control" placeholder="${footwearObj.getProductType()}" name="prodType">
<br/>
<h4>imageUrl:</h4><input type="text" class="form-control" placeholder="${footwearObj.getImageUrl()}" name="prodImgUrl">
<br/>
<h4>productDesc:</h4><input type="text" class="form-control" placeholder="${footwearObj.getProductDesc()}" name="prodDesc">
<br/>
<a href="http://localhost:8090/mainapp/manageProducts"><button type="submit"> Submit</button></a>
</form>
</div>
</body>
</html>