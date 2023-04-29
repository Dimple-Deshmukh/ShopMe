<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<%@include file="Component/common_css_js.jsp"%>

</head>
<body style="background: black">

	<%@include file="Component/navbar.jsp"%>

	<%@include file="Component/message.jsp" %>

	<div class="container-fluid">

		<div class="row mt-5 ">
			
		
			<div class="col-md-4 offset-md-4">

				<div class="card bg-dark text-light">
				

					<div class="card-body">
					
						<h3 class="text-center my-3">Sign Up !!</h3>
						<form action="RegisterServlet" method="post">


							<div class="form-group">
								<label for="name">User Name</label> <input type="text" required="required"
									class="form-control" id="name" placeholder="Enter here"
									name="uname">
							</div>
							<div class="form-group">
								<label for="email">User Email</label> <input type="email" required="required"
									class="form-control" id="name" placeholder="Enter here"
									name="uemail">
							</div>
							<div class="form-group">
								<label for="pass">Password</label> <input type="password" required="required"
									class="form-control" id="pass" placeholder="Enter here"
									name="upass">
							</div>
							<div class="form-group">
								<label for="rpass">Re-enter Password</label> <input
									type="password" required="required" class="form-control" id="rpass"
									placeholder="Enter here" name="rupass">
							</div>
							<a href="login.jsp" class="text-warning">If already user, Login here!</a>
							<div class="container mt-3 text-center">
								<button type="submit" class="btn btn-success">Register</button>
							</div>

						</form>


					</div>

				</div>

			</div>

		</div>


	</div>





</body>
</html>