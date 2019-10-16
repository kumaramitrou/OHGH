package com.ohdgh.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ohdgh.db.EventsDao;

@WebServlet("/Solution")
public class SolutionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Solution, Tracking Id is : "+ request.getParameter("trackingid"));
		String trackingId = request.getParameter("trackingid");
		
		EventsDao eventsDao = new EventsDao();
		eventsDao.markResolved(trackingId);
		
		if(request.getParameter("redirectto")!=null) {
			System.out.println(request.getParameter("redirectto"));
			RequestDispatcher rd = request.getRequestDispatcher("Grievance");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Show?trackingid="+trackingId);
			rd.forward(request,response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside Solution Post.");
		doGet(request, response);
	}

}
