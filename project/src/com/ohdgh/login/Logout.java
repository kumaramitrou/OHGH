package com.ohdgh.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.NotificationDao;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 2513153188268111948L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		NotificationDao notifDao = new NotificationDao();
		notifDao.resetNotification((String)session.getAttribute("username"));
		
		session.removeAttribute("username");
		session.removeAttribute("landingpage");
		session.removeAttribute("notif");
		session.removeAttribute("message");
		session.removeAttribute("update");
		session.invalidate();
		response.sendRedirect("Login.jsp");
	}
}
