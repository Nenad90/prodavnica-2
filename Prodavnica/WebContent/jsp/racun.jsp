<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "model.User" %>
     <%@ page import = "model.Bill" %>
      <%@ page import = "model.Product" %>
       <%@ page import = "java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>racun</title>
</head>
<body>
	<% User user = (User)session.getAttribute("ovdeCuvamUsera");
	   Bill bill = (Bill)session.getAttribute("racun");
	%>
	<h1>POZDRAV <%=user.getUserName() %> VAS RACUN JE</h1>
	
	<table>
		<h2><tr>
			<th> ime proizvoda</th>
			<th> cena </th>
			<th> kolicina</th>
			<th> popust</th>
		</tr></h2>
		<% for(Product p: bill.getListOfProducts()) {%>
		<tr>
			<td><%=p.getName()%></td>
			<td><%=p.getPrice()%></td>
			<td><%=p.getQuantity()%></td>
			<td><%=p.getDiscount()%></td>
		</tr>
		<%
		}
		%>
	</table>
	
	<p>Ukupan racun je: <h2><%=bill.getTotalPrice() %></h2></p>
	
	<a href = "user.jsp"> back to user page </a>
</body>
</html>