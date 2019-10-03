package com.ohdgh.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohdgh.db.StudentDao;
import com.ohdgh.model.Student;

@WebServlet("/Student")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDao dao = new StudentDao();
		List<Student> students = dao.listRows();
		
		System.out.println("ViewStudent Servlet.");
		request.setAttribute("students", students);
		RequestDispatcher rd = request.getRequestDispatcher("ViewStudentsAdmin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddStudentAdmin.jsp");
		try {
			StudentDao dao = new StudentDao();
			String rollNo = request.getParameter("rollno");
			if(dao.getRow(rollNo) == null) {
				
				//add student
				Student student = new Student();
				student.setName(request.getParameter("name"));
				student.setBatch(request.getParameter("batch"));
				student.setStream(request.getParameter("stream"));
				student.setRollNo(rollNo);
				
				dao.addRow(student);
				
				request.setAttribute("message", "Student added Successfully.");
			}
			else {
				request.setAttribute("message", "Student already exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "Oops, Something went wrong!");
		}
		rd.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Delete Student Called.");
		// TODO Auto-generated method stub
	}

}
