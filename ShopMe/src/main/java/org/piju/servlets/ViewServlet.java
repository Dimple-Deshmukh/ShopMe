package org.piju.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.piju.dao.AdminDao;
import org.piju.helperClass.FactoryProvider;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String view = request.getParameter("view");
		AdminDao adminDao = new AdminDao(FactoryProvider.getEM());
		
		if (view.trim().equals("category")) {
			//show category
			response.sendRedirect(request.getContextPath()+"/viewCategory.jsp");
			
			
		}
		else if(view.trim().equals("product"))
		{
			//show products
			response.sendRedirect(request.getContextPath()+"/viewProducts.jsp");
			
		}
		else if (view.trim().equals("delCat")) {
			int id = Integer.parseInt(request.getParameter("id"));
			adminDao.deleteCategory(id);
			response.sendRedirect(request.getContextPath()+"/viewCategory.jsp");
		}
		else if (view.trim().equals("delPro")) {
			int id = Integer.parseInt(request.getParameter("id"));
			adminDao.deleteProduct(id);
			response.sendRedirect(request.getContextPath()+"/viewProducts.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
