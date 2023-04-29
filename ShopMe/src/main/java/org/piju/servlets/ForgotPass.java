package org.piju.servlets;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ForgotPass() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String umail = request.getParameter("uemail");
		RequestDispatcher dispatcher = null;
		int optvalue = 0;
		HttpSession httpSession = request.getSession();
		
		if (umail != null || !umail.equals("")) {
			//sending opt
			Random random = new Random();
			optvalue = random.nextInt(1255650);
			
			//whom to send
			String to = umail;
			
			//get the session object
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.socketFactory.port", "465");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.port", "465");
			
			Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator(){
				
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					// TODO Auto-generated method stub
					//from which mail you want to send otp
					return new PasswordAuthentication("dimpledeshmukh1118@gmail.com", "dacmdgzkkoypjhaq");
				}
			});
			
			//compose message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(umail));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				message.setSubject("ShopMe - OTP");
				message.setText("Your OTP is : "+ optvalue);
				
				//send message
				
				Transport.send(message);
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			dispatcher = request.getRequestDispatcher("otpPage.jsp");
			request.setAttribute("message", "OTP is sent to your email id");
			httpSession.setAttribute("otp", optvalue);
			httpSession.setAttribute("email", umail);
			
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
