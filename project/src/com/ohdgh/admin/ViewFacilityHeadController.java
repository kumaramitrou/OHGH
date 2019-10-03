package com.ohdgh.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohdgh.db.FacilityHeadDao;
import com.ohdgh.db.StudentDao;
import com.ohdgh.model.Constants;
import com.ohdgh.model.FacilityHead;
import com.ohdgh.model.Student;

@WebServlet("/ViewFacilityHead")
public class ViewFacilityHeadController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacilityHeadDao dao = new FacilityHeadDao();
		List<FacilityHead> facilityHeads = dao.listRows();
		
		System.out.println("ViewStudent Servlet.");
		request.setAttribute("users", facilityHeads);
		request.setAttribute("userType", Constants.facilityHeadProperties);
		RequestDispatcher rd = request.getRequestDispatcher("ViewUsersAdmin.jsp");
		rd.forward(request, response);
	}
}
