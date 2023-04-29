<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ShopMe-New Password</title>

<%@include file="Component/common_css_js.jsp"%>
</head>

<body>
<%
	String umail = request.getParameter("email");
%>
	<div class="container mt-5" style="margin-left: 30%"> 
		
		<div class="row">
			<div class="col-md-6">
				<div class="card border-warning">
					<div class="card-header text-white" style="background-color: #db9f39">
						<h3 class="card-title text-center">Reset Password</h3>
					</div>
					<div class="card-body">
						<form action="NewPassword"  method="post">
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span style="background-color: #db9f39" class="input-group-text text-white" id="basic-addon1"><i class="fa fa-key" aria-hidden="true"></i></span>
								</div>
								<input required="required" type="text" class="form-control border-warning" placeholder="Enter new password" name="new_pass">
							</div>
							<div class="input-group mb-3">
								<div class="input-group-prepend">
									<span style="background-color: #db9f39" class="input-group-text text-white" id="basic-addon1"><i class="fa fa-key" aria-hidden="true"></i></span>
								</div>
								<input required="required" type="text" class="form-control border-warning" placeholder="Confirm new password" name="connew_pass">
							</div>
							<div class="container text-center">
								<input type="submit" class="btn font-weight-bold mt-3 mb-5 text-white form-control" value="Reset" style="background-color: #db9f39; font-size:20px; padding: 10px 0px">
							</div>
						</form>
					
					</div>
				</div>
			
			</div>
		</div>
	
	</div>

</body>
</html>