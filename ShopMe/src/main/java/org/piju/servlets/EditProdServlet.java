package org.piju.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.piju.dao.AdminDao;
import org.piju.entities.Product;
import org.piju.helperClass.FactoryProvider;

public class EditProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String prodName = request.getParameter("proName");
		String prodDesc = request.getParameter("proDes");
		int proPrice = Integer.parseInt(request.getParameter("proPrice"));
		int proDis = Integer.parseInt(request.getParameter("proDis"));
		int proQuan = Integer.parseInt(request.getParameter("proQuan"));
		
		AdminDao adminDao = new AdminDao(FactoryProvider.getEM());
		
		Product product = adminDao.getProductById(id);
		product.setProdName(prodName);
		product.setDesc(prodDesc);
		product.setPrice(proPrice);
		product.setDiscount(proDis);
		product.setProdQuantity(proQuan);
		adminDao.addProduct(product);
		response.sendRedirect(request.getContextPath()+"/viewProducts.jsp");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
