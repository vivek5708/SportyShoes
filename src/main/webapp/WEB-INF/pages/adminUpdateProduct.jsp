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
Update the Product
<form method="post">
Name :<input type="text" class="form-control" placeholder="${footwearObj.getName()}" name="prodName">
<br/>
Brand :<input type="text" class="form-control" placeholder="${footwearObj.getBrand()}" name="prodBrand">
<br/>
Price :<input type="text" class="form-control" placeholder="${footwearObj.getPrice()}" name="prodPrice">
<br/>
productType:<input type="text" class="form-control" placeholder="${footwearObj.getProductType()}" name="prodType">
<br/>
imageUrl:<input type="text" class="form-control" placeholder="${footwearObj.getImageUrl()}" name="prodImgUrl">
<br/>
productDesc:<input type="text" class="form-control" placeholder="${footwearObj.getProductDesc()}" name="prodDesc">
<br/>
<a href="http://localhost:8090/mainapp/manageProducts"><button type="submit"> Submit</button></a>
</form>
</div>
</body>
</html>