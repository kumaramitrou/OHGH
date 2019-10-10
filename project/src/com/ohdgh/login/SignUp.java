package com.ohdgh.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohdgh.db.FacilityHeadDao;
import com.ohdgh.db.StudentDao;
import com.ohdgh.db.UserDao;
import com.ohdgh.model.User;

@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = -2804172164347039161L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean addUser = true;
		User user = new User();
		UserDao dao = new UserDao();
		user.setEmail(request.getParameter("email"));
		if(dao.isEmailExist(user.getEmail())) {
			addUser = false;
			request.setAttribute("message", "User with same email already exist.");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		user.setUserName(request.getParameter("uname"));
		if(dao.isUserNameExist(user.getUserName())) {
			addUser = false;
			request.setAttribute("message", "User with same username already exist, Please choose unique username.");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		user.setType(request.getParameter("usertype"));
		user.setUid(request.getParameter("uid"));
		if(dao.isUIDExist(user.getUid())) {
			//check Uid exist.
			addUser = false;
			request.setAttribute("message", "User with same UID already exist.");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		if(user.getType().equalsIgnoreCase("WelcomeStudent.jsp")) {
			//check roll no exist.
			StudentDao studentDao = new StudentDao();
			if(studentDao.getRowByRollNo(user.getUid())==null) {
				addUser = false;
				request.setAttribute("message", "Roll Number is not added, please contact admin.");
				RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
				rd.forward(request, response);
			}
		}
		if(user.getType().equalsIgnoreCase("WelcomeFacilityHead.jsp")) {
			//check employee id exist
			FacilityHeadDao facilityHeadDao = new FacilityHeadDao();
			if (facilityHeadDao.getRowByEmpNo(user.getUid())==null) {
				addUser = false;
				request.setAttribute("message", "Employee Id is not added, please contact admin.");
				RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
				rd.forward(request, response);
			}
		}
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("pass"));
		if(user.getPassword() == null || user.getPassword().length() < 8) {
			addUser = false;
			request.setAttribute("message", "Password should have atleast 8 characters.");
			RequestDispatcher rd = request.getRequestDispatcher("SignUp.jsp");
			rd.forward(request, response);
		}
		user.setQuestion(request.getParameter("secques"));
		user.setAnswer(request.getParameter("secans"));
		if (addUser) {
			dao.addUser(user);
			request.setAttribute("message", "Signed up Successfully.");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}
}
