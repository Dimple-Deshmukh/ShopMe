package org.piju.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.Format.Field;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.piju.dao.AdminDao;
import org.piju.entities.Category;
import org.piju.entities.Product;
import org.piju.helperClass.FactoryProvider;

@MultipartConfig
public class AdminOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public AdminOperation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op = request.getParameter("operation");
		AdminDao adminDao = new AdminDao(FactoryProvider.getEM());
		if (op.trim().equals("addcategory")) {
			
			String title = request.getParameter("catTitle");
			Category category = new Category();
			category.setCategoryName(title);
			
			
			
			adminDao.addCategory(category);
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Category Added Successfully!");
			response.sendRedirect("admin.jsp");
			return;
			
		}
		else if (op.trim().equals("addproduct")) {
			
			String prodName = request.getParameter("prodName");
			String prodDisc = request.getParameter("prodDesc");
			int prodPrice = Integer.parseInt(request.getParameter("prodPrice"));
			int prodDis = Integer.parseInt(request.getParameter("prodDis"));
			int prodQuan = Integer.parseInt(request.getParameter("prodQuan"));
			int cat = Integer.parseInt(request.getParameter("cat"));
			
			Category category = adminDao.getCategoryById(cat);
			
			Part part = request.getPart("prodimg");
			String prodImg = part.getSubmittedFileName();
			
			
			try {
		
			String path = request.getRealPath("img")+File.separator+"Products"+File.separator+prodImg;
			
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			
			InputStream inputStream = part.getInputStream();
			
			byte[] data = new byte[inputStream.available()];
			
			inputStream.read(data);
			
			fileOutputStream.write(data);
			
			fileOutputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			Product product = new Product(prodName, prodDisc, prodPrice,prodDis, prodQuan, prodImg, category);
			adminDao.addProduct(product);
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Product Added Successfully!");
			response.sendRedirect("admin.jsp");
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
