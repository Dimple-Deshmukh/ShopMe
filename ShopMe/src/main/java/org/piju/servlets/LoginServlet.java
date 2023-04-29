package org.piju.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.piju.entities.User;
import org.piju.helperClass.FactoryProvider;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("upass");
		
		EntityManager entityManager = FactoryProvider.getEMFactory().createEntityManager();
		
		Query query = entityManager.createQuery("from User where email =: x");
		query.setParameter("x", uemail);
		HttpSession httpSession = request.getSession();
		try {
			
			User user = (User) query.getSingleResult();
			if (user.getEmail().equals(uemail) && user.getPassword().equals(upass)) {
				httpSession.setAttribute("current-user", user);
				
				if (user.getUserType().equals("admin")) {
					response.sendRedirect("admin.jsp");
				}
				else {
					response.sendRedirect("index.jsp");
				}
				
				
			}
			else {
				
				httpSession.setAttribute("message", "Invalid Email or Password !");
				response.sendRedirect("login.jsp");
			}
			
			
		} catch (Exception e) {
			
			httpSession.setAttribute("message", "User doesn't exist!");
			response.sendRedirect("login.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
