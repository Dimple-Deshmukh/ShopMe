<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopMe-Forgot Password</title>
<%@include file="Component/common_css_js.jsp" %>
</head>
<body>
	
	<div class="container mt-5" style="max-width: 901px;">
		
		<div class="card border-warning">
			<div class="card-header bg-warning text-white">
				<h4 class="card-title">Forgot your password?</h4>
				
			</div>
			<div class="card-body">
				<p>Change your password in three easy steps. This will help you secure your password!</p>
				<ol>
					<li>Enter your registered email address below.</li>
					<li>Our system will send an OTP on your email.</li>
					<li>Enter the OTP and change password</li>
				</ol>
				<br>
				<div class="container">
					<form action="ForgotPass" method="post">
						<div class="form-group">
							<label for="email">Enter your email address</label>
							<input required="required" type="email" id="email" name="uemail" class="form-control">
							<small id="emailHelp" class="form-text text-muted">Enter registred email address. OTP will be send to this mail.</small>
						</div>
						<div class="container text-center">
							<input type="submit" class="btn btn-outline-success" value="Get OTP">
							<a href="login.jsp" class="btn btn-outline-danger">Back to Login</a>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	
	</div>

</body>
</html>