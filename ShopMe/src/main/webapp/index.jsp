<%@page import="org.piju.helperClass.Shorten"%>

<%@page import="org.piju.entities.Product"%>
<%@page import="org.piju.entities.Category"%>
<%@page import="java.util.List"%>
<%@page import="org.piju.dao.AdminDao"%>
<%@page import="org.piju.helperClass.FactoryProvider"%>
<html>

<head>
<title>ShopMe-Home</title>
<%@include file="Component/common_css_js.jsp" %>


<style type="text/css">
.list-group-item.active {
	background-color: #495057;
	border-color: #495057
}
.myImg{
	max-height: 250px;
	max-width: auto;

}
sub{
	text-decoration: line-through;
	color: grey;
}
.product{cursor:pointer;}
</style>
</head>

<body>

	<%@include file="Component/navbar.jsp"%>
	<%@include file="Component/common_modal.jsp"%>

	<%
	AdminDao adminDao = new AdminDao(FactoryProvider.getEMFactory().createEntityManager());

	List<Category> catList = adminDao.getCategory();

	String cat = request.getParameter("category");
	
	List<Product> prodList = null;
	
	if( cat == null || cat.trim().equals("all"))
	{
		prodList = adminDao.getProducts();
	}else{
		int catId = Integer.parseInt(cat);
		
		prodList = adminDao.getProductsById(catId);
		
	}
	
	
	
	
	%>
	
	<div class="row mt-3 mx-2">
		
		<%-- <div class="col-md-2 text-center">

			<div class="list-group">
				<a class="list-group-item list-group-item-action active"
					href="index.jsp?category=all">All Products</a>
				<%
				for (Category category : catList) {
				%>
				<a class="list-group-item list-group-item-action"
					href="index.jsp?category=<%= category.getCategoryId() %>"><%=category.getCategoryName()%></a>
				<%
				}
				%>
			</div>

		</div> --%>
		<div class="col-md-12">
			<div class="row">
				<%
				for (Product product : prodList) {
				%>
				<div class="col-md-3">

					<div class="card mt-2 product">
						<div class="container text-center">
							<img alt="product img" class="img-fluid myImg" src="img/Products/<%= product.getProdImg() %>">
						</div>
						<div class="card-body">
							<h5 class="card-title text-center ">
								<%=product.getProdName()%>
							</h5>
							<p class="card-text">
								<%=Shorten.get10Words(product.getDesc())%>
							</p>
							<h5 class="text-danger"> <sup>&#8377;</sup> <%= product.getDiscountedPrice() %> <sub>&#8377;<%= product.getPrice() %></sub> <small>(<%= product.getDiscount()%>% off)</small> </h5>
						</div>
						<div class="card-footer text-center">
							<input type="button" value="Add To Cart" onclick="add_to_cart(<%= product.getProdId() %>,'<%= product.getProdName() %>',<%= product.getPrice() %>)" class="btn btn-warning">
							<input type="button" value="Buy Now" onclick="buyNow(<%= product.getProdId() %>,'<%= product.getProdName() %>',<%= product.getPrice() %>)" class="btn btn-success">
						</div>


					</div>

				</div>
				<%
				}
				if(prodList.size() == 0){
					out.println("<h3>No item in this category</h3>");
				}
				
				
				%>
			</div>
		</div>
		
		
	</div>
	


</body>
</html>
