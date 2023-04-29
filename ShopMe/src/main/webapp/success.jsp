<%
User user1 = (User) session.getAttribute("current-user");

if (user1 == null) {
	session.setAttribute("message", "You Are Logged Out. Please Log In !");
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
<title>ShopMe-Success</title>

<%@include file="Component/common_css_js.jsp"%>

<%@include file="Component/navbar.jsp"%>

<style>
	.fa{
		font-size: 100px;
		color: green;
		
	
	}
	.myLink{
		display: border-box;
		background-color: black;
		color: white;
		text-decoration: none;
		padding: 15px;
		border-radius: 15px;
		
	}
	.myLink:hover{
		color: white;
		text-decoration: none;
		background-color: grey;
	}
</style>

<script>
	
localStorage.clear();

</script>
	
	
	

</head>
<body>

	<div class="container mt-5 text-center" >
		
		<div class="card">
			
			
				
				
			<div class="card-body">
				<i class="fa fa-check-circle-o" aria-hidden="true"></i>
				<h5 style="color: green;font-size: 50px ; font-family: Brush Script MT;">Thank you!</h5>
				
				<h6>Your order has been successfully placed!</h6>
				<br>
				<a class="myLink mt-2" href="index.jsp">Continue Shopping</a>
				<br><br><br>
			</div>
		
		</div>
	
	</div>

</body>
</html>