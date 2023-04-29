package org.piju.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.piju.entities.User;
import org.piju.helperClass.FactoryProvider;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upass");
		String repassword = request.getParameter("rupass");
		
		
		if(password.equals(repassword))
		{

			Query query = FactoryProvider.getEMFactory().createEntityManager().createQuery("from User where email =: x");
			query.setParameter("x", email);
			try {
				
				User user = (User) query.getSingleResult();
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "User Already Exist !");
				response.sendRedirect("register.jsp");
				
				
			} catch (Exception e) {
				// TODO: handle exception
				User user1 = new User(name, email,password,"normal");
				EntityManager em = FactoryProvider.getEMFactory().createEntityManager();
				EntityTransaction et = em.getTransaction();
				et.begin();
				em.persist(user1);
				et.commit();
				
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("message", "Registration Successful !");
				response.sendRedirect("register.jsp");
			}
	
		}
		else {
			HttpSession session =  request.getSession();
			session.setAttribute("message", "Password does not match!");
			response.sendRedirect("register.jsp");
			return;
			
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
