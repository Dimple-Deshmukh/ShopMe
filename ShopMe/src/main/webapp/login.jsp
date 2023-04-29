<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopMe-Login</title>
<%@include file="Component/common_css_js.jsp"%>

</head>
<body style="background-color: black">

	<%@include file="Component/navbar.jsp"%>
	<%@include file="Component/message.jsp" %>
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-5 offset-md-4">
				<div class="card bg-dark text-white rounded">
					<div class="card-header pt-4 text-center">
						<h3>Login Page</h3>
					</div>
					<div class="card-body">
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="email">User Email</label> <input type="email"
									required="required" class="form-control" id="name"
									placeholder="Enter here" name="uemail">
							</div>
							<div class="form-group">
								<label for="pass">Password</label> <input type="password"
									required="required" class="form-control" id="pass"
									placeholder="Enter here" name="upass">
							</div>
							<div class="form-group">
								<a href="register.jsp" class="text-warning">if new user,
								click here!</a>
							<a href="forgotPassword.jsp" class="text-danger float-right">Forgot password?</a>
							</div>
							
							<div class="container text-center">
								<button type="submit" class="btn btn-success">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>