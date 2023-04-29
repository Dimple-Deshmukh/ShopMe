<%@page import="org.piju.dao.UserDao"%>
<%@page import="org.piju.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="org.piju.helperClass.FactoryProvider"%>
<%@page import="org.piju.dao.AdminDao"%>
<%@page import="org.piju.entities.User"%>
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
<title>ShopMe - Admin</title>
<%@include file="Component/common_css_js.jsp"%>

</head>
<body>

	<%@include file="Component/navbar.jsp"%>
	<%
	UserDao userDao = new UserDao();
	AdminDao adminDao = new AdminDao(FactoryProvider.getEM());
	%>
	<div class="container admin">
		<div class="container text-center mt-2">
			<%@include file="Component/message.jsp"%>
		</div>
		<!-- first row -->
		<div class="row mt-5">
			<div class="col-md-4">
				<div class="card text-center">
					<div class="card-body">
						<div class="container">
							<img alt="user img" src="img/user.png" style="max-width: 100px"
								class="img-fluid">
						</div>
						<h1><%=userDao.userCount()%></h1>
						<h1 class="text-uppercase text-muted">Users</h1>

					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card text-center" data-toggle="modal" data-target="#viewCategory">
					<a style="text-decoration: none;" href="/ShopMe/ViewServlet?view=category">
					<div class="card-body">
						<div class="container">
							<img alt="categories img" src="img/category.png"
								style="max-width: 100px" class="img-fluid">
						</div>
						<h1 class="text-dark"><%=adminDao.categoryCount()%></h1>
						<h1 class="text-uppercase text-muted">Categories</h1>
					</div>
					</a>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card text-center">
					<a style="text-decoration: none;" href="/ShopMe/ViewServlet?view=product">
					<div class="card-body">
						<div class="container">
							<img alt="product img" src="img/product.png"
								style="max-width: 100px" class="img-fluid">
						</div>
						<h1 class="text-dark"><%=adminDao.productCount()%></h1>
						<h1 class="text-uppercase text-muted">Products</h1>
					</div>
					</a>
				</div>
			</div>
		</div>
		<!-- second row -->
		<div class="row mt-3">
			<div class="col-md-6">
				<div class="card text-center" data-toggle="modal"
					data-target="#add-category-modal">
					<div class="card-body">
						<div class="container">
							<img alt="add cat img" src="img/addCategory.png"
								style="max-width: 100px" class="img-fluid">
						</div>
						<h1 class="text-uppercase text-muted mt-2">Add Category</h1>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card text-center" data-toggle="modal"
					data-target="#add-product-modal">
					<div class="card-body">
						<div class="container">
							<img alt="add prod img" src="img/addProduct.png"
								style="max-width: 100px" class="img-fluid">
						</div>
						<h1 class="text-uppercase text-muted mt-2">Add Product</h1>
					</div>
				</div>
			</div>

		</div>
	</div>

	<!-- start addCategory modal -->

	<div class="modal fade" id="add-category-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">

				<div class="modal-header bg-dark text-light">
					<h5 class="modal-title" id="exampleModalLabel">Category
						Details</h5>
					<button type="button" class="close text-light" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="AdminOperation" method="post">
						<input type="hidden" name="operation" value="addcategory" />
						<div class="form-group">
							<label for="catTitle">Category Title</label> <input type="text"
								id="catTitle" name="catTitle" required="required" class="form-control">
						</div>
						<div class="container text-center">
							<input type="submit" class="btn btn-success" value="Add Category"></input>
							<input type="reset" class="btn btn-danger"></input>
						</div>

					</form>
				</div>



			</div>
		</div>
	</div>

	<!-- end addCategory modal -->


	<!-- start add product modal -->
	<div class="modal fade" id="add-product-modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header bg-dark text-light">
					<h5 class="modal-title" id="exampleModalLabel">Product Details</h5>
					<button type="button" class="close text-light" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="AdminOperation" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="operation" value="addproduct" />
						<div class="form-group">
							<label for="prodName">Product Name</label> <input required="required" type="text"
								id="prodName" name="prodName" class="form-control">
						</div>
						<div class="form-group">
							<label for="prodDesc">Product Description</label>
							<textarea id="prodDesc" required="required" name="prodDesc" class="form-control"></textarea>
						</div>
						<div class="form-group">
							<label for="prodPrice">Product Price</label> <input type="number"
								id="prodPrice" name="prodPrice" required="required" class="form-control">
						</div>
						<div class="form-group">
							<label for="prodDis">Product Discount</label> <input
								type="number" id="prodDis" required="required" name="prodDis" class="form-control">
						</div>
						<div class="form-group">
							<label for="prodQuan">Product Quantity</label> <input
								type="number" required="required" id="prodQuan" name="prodQuan" class="form-control">
						</div>
						<%
						AdminDao ad = new AdminDao(FactoryProvider.getEM());
						List<Category> list = ad.getCategory();
						%>
						<div class="form-group">
							<label for="prodcat">Category</label> <select name="cat"
								id="prodcat" class="form-control">
								<%
								for (Category category : list) {
								%>
								<option value="<%=category.getCategoryId()%>"><%=category.getCategoryName()%></option>

								<%
								}
								%>
							</select>
						</div>
						<div class="form-group">
							<label for="prodImg">Product Image</label> <input
								class="form-control" type="file" required="required" id="prodImg" name="prodimg">
						</div>
						<div class="container text-center">
							<input type="submit" class="btn btn-success" value="Add Product"></input>
							<input type="reset" class="btn btn-danger"></input>
						</div>

					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- end addProductb MOdal -->

	<!-- start view category model -->
	<%-- 
	<div class="modal fade" id="viewCategory" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header bg-secondary text-white">
					<h5 class="modal-title" id="exampleModalLabel">Categories</h5>
					<button type="button" class="close text-white" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<table class="table text-center">
						<thead>
							<tr>
								<th>Id</th>
								<th>Category</th>
								<th colspan='2'>Action</th>
							</tr>
						</thead>
						<%
							int count = 0;
							for(Category category : list)
							{
								count++;
						%>
							
							<tr>
								<td><%= count %></td>
								<td><%= category.getCategoryName() %></td>
								<td><button onclick="catDel()" class="btn btn-danger">Delete</button></td>
								<td><button class="btn btn-primary">Edit</button></td>
							</tr>
							
						<% } %>
						
					</table>
				</div>
				
			</div>
		</div>
	</div>
 --%>
	<!-- end view category model -->

</body>
</html>