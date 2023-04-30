<%
	User user3 = (User) session.getAttribute("current-user");
	if(user3 == null)
	{
		session.setAttribute("message", "Please Login To Continue!");
		response.sendRedirect("login.jsp");
		return;
	}
	
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopMe-Checkout</title>

<%@include file="Component/common_css_js.jsp"%>
<%@include file="Component/navbar.jsp"%>
<%@include file="Component/common_modal.jsp"%>
<style>
.card {
	border: 1px solid #F1887D;
}
</style>
</head>
<body>

	<div class="container">

		<div class="row mt-5">

			<div class="col-md-8">
				<div class="card">
					<div class="card-header" style="background-color: #F1887D">
						<h3 class="card-title text-center text-white">Your cart items</h3>
					</div>
					<div class="card-body">
						<div class="cart-body"></div>
					</div>
				</div>

			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-header" style="background-color: #F1887D">
						<h3 class="card-title text-center text-white">Shipping
							Details</h3>
					</div>
					<div class="card-body">
						<form id="checkForm" method="post">
							<input type="hidden" id="jsCart" name="jsCart">
							<div class="form-group">
								<label for="name">Your Name</label> 
								<input required="required" type="text" id="name" name="uname" 
								value="<%= user3.getName() %>" class="form-control" placeholder="Enter name">
							</div>
							<div class="form-group">
								<label for="email">Email address</label> <input required="required" type="email"
									class="form-control" id="email"
									value="<%= user3.getEmail() %>" aria-describedby="emailHelp"
									placeholder="Enter email" name="email">
							</div>
							
							<div class="form-group">
								<label for="phoneNo">Phone No </label>
								<input required="required" type="number" class="form-control" id="phoneNo" name="phone">
							</div>
							
							<div class="form-group">
								<label for="textarea">Address </label>
								<textarea required="required" class="form-control" id="textarea"
									rows="3" name="address"></textarea>
							</div>
							<div class="container text-center">
								<input class="btn btn-success" onclick="paymentStart()" type="submit" value="Order Now">
								<a href="index.jsp" class="btn btn-warning">Continue Shopping</a>
							</div>
						</form>
					</div>

				</div>

			</div>

		</div>

	</div>


</body>
</html>