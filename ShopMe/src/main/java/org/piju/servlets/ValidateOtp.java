package org.piju.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ValidateOtp() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String umail = request.getParameter("email");
		int uotp = Integer.parseInt(request.getParameter("uotp"));
		HttpSession httpSession = request.getSession();
		int sesotp = (Integer) httpSession.getAttribute("otp");
		
		RequestDispatcher dispatcher = null;
		
		if (uotp == sesotp) {
			request.setAttribute("email", request.getAttribute("email"));
			request.setAttribute("status", "success");
			dispatcher = request.getRequestDispatcher("newPassword.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("message", "Wrong OTP");
			dispatcher = request.getRequestDispatcher("otpPage.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
