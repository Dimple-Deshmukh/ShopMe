package org.piju.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.piju.dao.AdminDao;
import org.piju.entities.Category;
import org.piju.entities.Product;
import org.piju.helperClass.FactoryProvider;

public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String edit = request.getParameter("edit");
		
		AdminDao adminDao = new AdminDao(FactoryProvider.getEM());
		
		
			int id = Integer.parseInt(request.getParameter("id"));
			String catName = request.getParameter("catName");
			
			Category category = adminDao.getCategoryById(id);
			category.setCategoryName(catName);
			adminDao.addCategory(category);
			response.sendRedirect(request.getContextPath()+"/viewCategory.jsp");
			
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
