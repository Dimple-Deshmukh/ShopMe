package org.piju.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.piju.dao.UserDao;
import org.piju.entities.User;

public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewPassword() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		String email = (String) httpSession.getAttribute("email");
		System.out.println(email);
		String newPass = request.getParameter("new_pass");
		String conPass = request.getParameter("connew_pass");
		RequestDispatcher dispatcher = null;
		
		
		
		if (newPass.equals(conPass)) {
			UserDao dao = new UserDao();
			User user = dao.getUserByEmail(email);
			
			if (user != null) {
				user.setPassword(newPass);
				dao.saveUser(user);
				httpSession.setAttribute("message", "Password Reset Successful!");
				dispatcher = request.getRequestDispatcher("login.jsp");
				
			}
			else {
				
				httpSession.setAttribute("message", "Password Reset Failed!");
				dispatcher = request.getRequestDispatcher("login.jsp");
				
			}
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
