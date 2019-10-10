package com.ohdgh.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.UserDao;

@WebServlet("/Password")
public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDao dao = new UserDao();
		String userName = (String)session.getAttribute("username");
		String existingPassword = request.getParameter("opass");
		if(dao.checkCredential(userName, existingPassword)) {
			String newPassword = request.getParameter("pass");
			if(newPassword == null || newPassword.length() < 8) {
				request.setAttribute("message", "Password should have atleast 8 characters.");
			}
			else {
				dao.changePassword(userName, newPassword);
				request.setAttribute("message", "Password Changed successfully.");
			}
			RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("message", "Password Incorrect.");
			RequestDispatcher rd = request.getRequestDispatcher("ChangePassword.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
