package org.piju.servlets;

import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.json.JSONArray;
import org.json.JSONObject;
import org.piju.dao.CheckoutDao;
import org.piju.entities.Orders;
import org.piju.entities.ShippingDetails;
import org.piju.helperClass.FactoryProvider;



public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String str = request.getParameter("jsCart");
		
		String names = "";
		String quantities = "";
		
		CheckoutDao checkoutDao = new CheckoutDao(FactoryProvider.getEM());
		
		JSONArray jsonArray = new JSONArray(str);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			names = names+ "," + jsonObject.getString("productName");
			quantities = quantities + ","+ jsonObject.getInt("productQuantity");
	checkoutDao.decreaseQuanity(jsonObject.getString("productName"),jsonObject.getInt("productQuantity"));
//			System.out.println(jsonObject.getString("productName"));
		}
		
//		System.out.println(names);
//		System.out.println(quantities);
//		
//		System.out.println("---------------------------------------");
//		
		String userName = request.getParameter("uname");
		String userEmail = request.getParameter("email");
		String userAddress = request.getParameter("address");
		long userPhone = Long.parseLong(request.getParameter("phone"));
	
		int id = checkoutDao.getUserId(userEmail);
		System.out.println("user id : "+id);
		
		System.out.println(names + " " + quantities + " "+id);
		Orders orders = new Orders(names, quantities, id);
		checkoutDao.saveOrders(orders);
	
		int oid = checkoutDao.getOrderId(id);
		
		ShippingDetails details = new ShippingDetails(userAddress, userPhone,id ,oid);
		checkoutDao.saveShippingDetails(details);
		
		response.sendRedirect("success.jsp");
		
//		System.out.println(userName + " " + userEmail);
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
