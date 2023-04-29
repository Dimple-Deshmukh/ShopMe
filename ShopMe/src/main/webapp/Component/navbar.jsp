<%@page import="org.piju.entities.User"%>

<%@page import="org.piju.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="org.piju.dao.AdminDao"%>
<%@page import="org.piju.helperClass.FactoryProvider"%>
<%
User user2 = (User) session.getAttribute("current-user");
%>



<nav class="navbar navbar-expand-md navbar-dark bg-dark" style="position: sticky; top: 0px; z-index:1">
	<a class="navbar-brand" href="index.jsp">ShopMe</a>
	
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp?category=all">Home
					<span class="sr-only">(current)</span>
			</a></li>
			
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Categories </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<% AdminDao adminDao1 = new AdminDao(FactoryProvider.getEMFactory().createEntityManager());

					List<Category> navCatList = adminDao1.getCategory();
						for(Category category : navCatList){
					 %>
					<a class="dropdown-item" href="index.jsp?category=<%= category.getCategoryId() %>"><%= category.getCategoryName() %></a> 
					<%} %>
					
				</div></li>

		</ul>
		<ul class="navbar-nav mr-10">
			<li class="nav-item">
				<a class="nav-link" href="#!" data-toggle="modal" data-target="#cart">
				<i class="fa fa-cart-plus" style="font-size: 25px;color:pink"></i>
				<span class="cart-items" style="color: pink">( 0 )</span>
				</a>
			</li>
			
			<%
			if (user2 == null) {
			%>
			<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
			<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a></li>

			<%
			} else {
			%>

			<li class="nav-item"><a class="nav-link" href="<%= user2.getUserType().equals("admin")? "admin.jsp" : "index.jsp" %>"><%= user2.getName() %></a></li>
			<li class="nav-item"><a class="nav-link" href="LogoutServlet">Logout</a></li>

			<%
			}
			%>





		</ul>

	</div>
</nav>