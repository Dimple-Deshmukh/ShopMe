<%@page import="org.piju.entities.Product"%>
<%@page import="org.piju.helperClass.FactoryProvider"%>
<%@page import="org.piju.dao.AdminDao"%>
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


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopMe-Edit</title>
<%@include file="Component/common_css_js.jsp"%>
</head>
<body style="background-color: gray">
	<%@include file="Component/navbar.jsp"%>

	<%
	int id = Integer.parseInt(request.getParameter("id"));
	AdminDao adminDao = new AdminDao(FactoryProvider.getEM());
	Product product = adminDao.getProductById(id);
	%>

	<div class="container mt-5"
		style="max-width: 800px; border-radis: 50px">
		<div class="row">
			<div class="col-md-12">
				<form action="EditProdServlet" method="post">
					<input type="hidden" name="id" value="<%= product.getProdId() %>">
					<div class="card">
						<div class="card-header bg-dark text-white">
							<h3>Product Details</h3>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="proName">Product Name</label> <input
									class="form-control" type="text" id="proName" name="proName" value="<%= product.getProdName() %>">
							</div>
							<div class="form-group">
								<label for="proDes">Product Description</label>
								<textarea rows="3" class="form-control" id="proDes" name="proDes" ><%= product.getDesc() %></textarea>
							</div>
							<div class="form-row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="proPrice">Product Price</label>
										<input type="number" id="proPrice" class="form-control" name="proPrice" value="<%= product.getPrice() %>">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="proDis">Product Discount</label>
										<input type="number" id="proDis" class="form-control" name="proDis" value="<%= product.getDiscount() %>">
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="proQuan">Product Quantity</label>
										<input type="number" id="proQuan" class="form-control" name="proQuan" value="<%= product.getProdQuantity()%>">
									</div>
								</div>
							</div>
							<div class="container text-center">
								<input class="btn btn-success" type="submit"
									value="Save Changes">
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

	</div>

</body>
</html>>