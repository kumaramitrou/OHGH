package com.ohdgh.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohdgh.db.FacilityHeadDao;
import com.ohdgh.db.StudentDao;

@WebServlet("/AddFacilityHead")
public class AddFacilityHeadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddFacilityHeadAdmin.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddFacilityHeadAdmin.jsp");
		try {
			FacilityHeadDao dao = new FacilityHeadDao();
			String empNo = request.getParameter("empno");
			if(dao.getRow(empNo) == null) {
				//add FacilityHead
				request.setAttribute("message", "Facility Head added Successfully.");
			}
			else {
				request.setAttribute("message", "Facility Head already exist");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "Oops, Something went wrong!");
		}
		rd.forward(request, response);
	}
}
