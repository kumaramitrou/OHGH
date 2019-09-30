package com.ohdgh.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.UserDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		System.out.println("Inside Login");
		
		if (userDao.checkCredential(uname, pass)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("WelcomeAdmin.jsp");
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

}
