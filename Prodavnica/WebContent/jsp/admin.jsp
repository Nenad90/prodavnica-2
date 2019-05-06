<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin strana</title>
</head>
<body>
	<h1>dobrodosli ADMIN </h1>
	
	<p>Dodaj proizvode:</p>
	<form action="../AdminAddProductServlet" method="get">
		<input type = "text" placeholder = "product name" name = "name"><br><br>
		<input type = "text" placeholder = "product price" name = "price"><br><br>
		<input type = "text" placeholder = "product stock" name = "stock"><br><br>
		<input type = "text" placeholder = "product quantity" name = "quantity"><br><br>
		<input type = "text" placeholder = "product discount" name = "discount"><br><br>
		<input type = "submit" value = "ubaci proizvod"><br><br>
	</form>
</body>
</html>