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
import com.ohdgh.db.UserDao;
import com.ohdgh.model.FacilityHead;

@WebServlet("/FacilityHead")
public class FacilityHeadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacilityHeadDao dao = new FacilityHeadDao();
		List<FacilityHead> facilityHeads = dao.listRows();
		
		System.out.println("Get FacilityHead.");
		request.setAttribute("facilityheads", facilityHeads);
		RequestDispatcher rd = request.getRequestDispatcher("ViewFacilityHeadAdmin.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("AddFacilityHeadAdmin.jsp");
		try {
			FacilityHeadDao dao = new FacilityHeadDao();
			String empNo = request.getParameter("empno");
			String facility = request.getParameter("facility");
			if(dao.distinctFacility(facility)) {
				if(dao.getRowByEmpNo(empNo) == null) {
					
					//add FacilityHead
					FacilityHead facilityHead = new FacilityHead();
					facilityHead.setEmpNo(empNo);
					facilityHead.setName(request.getParameter("name"));
					facilityHead.setDepartment(request.getParameter("department"));
					facilityHead.setSpecialization(request.getParameter("specialization"));
					facilityHead.setFacility(facility);
					
					dao.addRow(facilityHead);
					
					request.setAttribute("message", "Facility Head added Successfully.");
				}
				else {
					request.setAttribute("message", "Facility Head already exist");
				}
			}
			else {	
				request.setAttribute("message", "Facility already exist for other Facility Head.");
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "Oops, Something went wrong!");
		}
		rd.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String empId = request.getParameter("id");
			FacilityHeadDao dao = new FacilityHeadDao();
			UserDao userDao = new UserDao();
			FacilityHead facilityHead = dao.getRowById(empId);
			System.out.println(empId);
			userDao.removeUserByUid(facilityHead.getEmpNo());
			dao.removeRow(empId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
