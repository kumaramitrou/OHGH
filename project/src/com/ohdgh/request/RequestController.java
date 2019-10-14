package com.ohdgh.request;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.EventsDao;
import com.ohdgh.db.FacilityHeadDao;
import com.ohdgh.model.Event;

@WebServlet("/Request")
public class RequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value = request.getParameter("id");
		HttpSession session = request.getSession();
		EventsDao eventsDao = new EventsDao();
		boolean from = true;

		if(session.getAttribute("landingpage")!=null)
		{
			from = ((String)session.getAttribute("landingpage")).equalsIgnoreCase("WelcomeStudent.jsp");
		}
		
		if(value.equalsIgnoreCase("viewall")) {
			request.setAttribute("requests", eventsDao.listAllRequests((String)session.getAttribute("username"), from));
		}
		if(value.equalsIgnoreCase("viewopen")) {
			request.setAttribute("requests", eventsDao.listOpenRequests((String)session.getAttribute("username"), from));
		}
		System.out.println(value);
		RequestDispatcher rd = request.getRequestDispatcher("RequestListView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Request Post.");
		HttpSession session = request.getSession();
		Event event = new Event();
		EventsDao dao = new EventsDao();
		FacilityHeadDao facilityHeadDao = new FacilityHeadDao();
		UUID uuid = UUID.randomUUID();;
		event.setSubject(request.getParameter("subject"));
		event.setMessage(request.getParameter("content"));
		event.setFacility(request.getParameter("facility"));
		event.setFrom((String)session.getAttribute("username"));
		event.setEventType("Request");
		event.setSerialNo(1);
		event.setTo(facilityHeadDao.getRowByFacility(request.getParameter("facility")));
		event.setTrackingId(uuid.toString());
		dao.addRequest(event);
		request.setAttribute("message", "Request added successfully.");
		RequestDispatcher rd = request.getRequestDispatcher("RequestNew.jsp");
		rd.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
