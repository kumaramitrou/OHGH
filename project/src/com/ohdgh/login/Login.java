package com.ohdgh.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.NotificationDao;
import com.ohdgh.db.UpdateDao;
import com.ohdgh.db.UserDao;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = -5785128843646570930L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("landingpage")!=null)
		{
			response.sendRedirect((String)session.getAttribute("landingpage"));
		}
		
		UserDao userDao = new UserDao();
		
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		
		if (userDao.checkCredential(uname, pass)) {
			
			session.setAttribute("username", uname);
			
			// Fetch Landing page based on user
			String landingPage = userDao.userLandingPage(uname);
			session.setAttribute("landingpage", landingPage);
			
			// Set Notification count
			NotificationDao notifDao = new NotificationDao();
			int notifCount = notifDao.getCount(uname);
			session.setAttribute("notif", notifCount > 0 ? notifCount : "");
			
			UpdateDao updateDao = new UpdateDao();
			int updateCount = updateDao.getCount();
			session.setAttribute("update", updateCount > 0 ? updateCount : "");
			
			response.sendRedirect(landingPage);
		} else {
			request.setAttribute("message", "Invalid User Name or Password.");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
			//response.sendRedirect("Login.jsp");
		}
	}

}
