<%@page import="org.piju.entities.Product"%>
<%
User user1 = (User) session.getAttribute("current-user");

if (user1 == null) {
	session.setAttribute("message", "You Are Logged Out. Please Log In !");
	response.sendRedirect("login.jsp");
	return;
} else {
	if (user1.getUserType().equals("normal")) {
		session.setAttribute("message", "You Are Logged Out. Please Log In !");
		response.sendRedirect("login.jsp");
		return;
	}

}
%>

<%@page import="org.piju.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="org.piju.helperClass.FactoryProvider"%>
<%@page import="org.piju.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopMe-Products</title>
<%@include file="Component/common_css_js.jsp" %>
 <style>
 	tr:hover
 	{
 		background-color: #343a40;
 	}
 	.thead{
 		background-color: #343a40;
 	}
 </style>

</head>
<body style="background: #212529">
	
	<%@include file="Component/navbar.jsp"%>
	
	
		<div class="row text-center mt-5 container-fluid">
		
			<div class="col-md-12">
				
				<table class="table table-dark">
					
					<thead class="font-weight-bold">
						<tr>
							<th>Id</th>
							<th>Product Name</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Discount</th>
							<th>Category</th>
							<th>Delete Product</th>
							<th>Edit Product</th>
						</tr>
					</thead>
					
					<% 
						AdminDao adminDao = new AdminDao(FactoryProvider.getEM());
						List<Product> list = adminDao.getProducts();
						int count = 0;
						for(Product product : list){
							count++;
						
					%>
					
					
					<tr>
						<td><%= count %></td>
						<td><%= product.getProdName() %></td>
						<td><%= product.getPrice() %></td>
						<td><%= product.getProdQuantity() %></td>
						<td><%= product.getDiscount() %></td>
						<td><%= product.getCategory().getCategoryName() %></td>
						<td> <a href="/ShopMe/ViewServlet?view=delPro&id=<%= product.getProdId() %>" class="btn btn-danger text-white">Delete</a> </td>
						<td> <a href="/ShopMe/editProduct.jsp?id=<%= product.getProdId() %>" class="btn btn-primary text-white">Edit</a> </td>
					</tr>
					
					<%} %>
				</table>
			
			</div>
		</div>
		


</body>
</html>