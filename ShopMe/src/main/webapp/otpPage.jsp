<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopMe-OTP</title>

<%@include file="Component/common_css_js.jsp"%>
</head>
<body>


	<div class="container mt-5" style="max-width: 60%; margin-left: 35%;">
		<div class="row">
			<div class="col-md-6">
				<div class="card border-warning">


					<div class="card-body">
						<div class="container mt-3 text-center">
							<i class="fa fa-unlock-alt"
								style="font-size: 100px; color: #db9f39;"></i>
							<h3>Enter OTP</h3>
							<%
							
							if (request.getAttribute("message") != null) {
								out.print("<p class='text-danger'>" + request.getAttribute("message") + "</p>");
							}
							%>
						</div>

						<br>
						<br>
						<form action="ValidateOtp" method="post">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span style="background-color: #db9f39" class="input-group-text text-white" id="basic-addon1"><i class="fa fa-key" aria-hidden="true"></i></span>
								</div>
								<input required="required" type="number" class="form-control border-warning" placeholder="Enter OTP" name="uotp">
							</div>
							<div class="container text-center">
								<input type="submit" class="btn font-weight-bold mt-3 mb-5 text-white form-control" value="Verify" style="background-color: #db9f39; font-size:20px; padding: 10px 0px">
							</div>
		
						</form>

					</div>
				</div>

			</div>
		</div>

	</div>

</body>
</html>