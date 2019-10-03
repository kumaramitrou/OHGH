package com.ohdgh.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohdgh.db.StudentDao;
import com.ohdgh.model.Student;

@WebServlet("/AddStudent")
public class AddStudentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddStudentAdmin.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddStudentAdmin.jsp");
		try {
			StudentDao dao = new StudentDao();
			String rollNo = request.getParameter("rollno");
			if(dao.getRow(rollNo) == null) {
				//add student
				request.setAttribute("message", "Student added Successfully.");
			}
			else {
				request.setAttribute("message", "Student already exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "Oops, Something went wrong!");
		}
		rd.forward(request, response);
	}
}
