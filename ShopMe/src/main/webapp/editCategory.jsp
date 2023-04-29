<%@page import="org.piju.entities.Category"%>
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
	Category category = adminDao.getCategoryById(id);
	%>

	<div class="container mt-5"
		style="max-width: 600px; border-radis: 50px">
		<div class="row text-center">
			<div class="col-md-12">
				<form action="EditServlet" method="post">
					<input type="hidden" name="id" value="<%= category.getCategoryId() %>">
					<div class="card">
						<div class="card-header bg-dark text-white">
							<h3>Category Details</h3>
						</div>
						<div class="card-body">
							<div class="form-group">
								<label for="catName">Category</label> <input
									class="form-control" type="text" id="catName" name="catName"
									value="<%=category.getCategoryName()%>">
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
</html>