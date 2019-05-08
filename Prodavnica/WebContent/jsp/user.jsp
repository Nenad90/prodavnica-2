<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- moraju rucno da se dodaju direktive!!! -->
<%@ page import = "model.User" %>
<%@ page import = "model.Product" %>
<%@ page import = "java.util.List" %>
<%@ page import = "bussinesService.UserMetode" %> <!-- direktiva -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user strana</title>
</head>
<body>
	<% 
	 User user = (User)session.getAttribute("ovdeCuvamUsera");
	 System.out.print(user.getUserName());
	%>
	<h1> dobrodosli USER </h1> <p><%=user.getUserName() %></p>
	<%
		UserMetode um = new UserMetode();
		List<Product> listaProizvoda = um.vratiListuProizvoda();
	%>
	<form action = "../RacunServlet" method="get">
	<table>
		<tr>
			<th>id product</th>
			<th>product name</th>
			<th>product price</th>
			<th>product stock</th>
			<th>product discount</th>
		</tr>
		
		<% for(Product p: listaProizvoda) {%>
			<tr>
				<td><%=p.getIdProduct() %> </td>
				<td><%=p.getName() %> </td>
				<td><%=p.getPrice() %> </td>
				<td><%=p.getStock() %> </td>
				<td><%=p.getDiscount()%> </td>
				<td><input type="checkbox" value=<%=p.getIdProduct()%> name="check"></td>
				<td>
					<select name = "quantity">
						<%for(int i =1; i<=p.getStock();i++){ %>
							<option><%=i %></option>
						<%} %>
					</select>
				</td>
			</tr>
			
			
		<%} %>
		<input type="submit" value="kupi">
	</table>
	</form>
	
</body>
</html>