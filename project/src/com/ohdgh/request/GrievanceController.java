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
import com.ohdgh.db.NotificationDao;
import com.ohdgh.model.Event;
import com.ohdgh.model.Notification;

@WebServlet("/Grievance")
public class GrievanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Called Grievance get");
		HttpSession session = request.getSession();
		EventsDao eventsDao = new EventsDao();
		boolean from = true;

		if(session.getAttribute("landingpage")!=null)
		{
			from = ((String)session.getAttribute("landingpage")).equalsIgnoreCase("WelcomeStudent.jsp");
		}
		
		request.setAttribute("grievances", eventsDao.listAllGrievances((String)session.getAttribute("username"), from));
		// Can add mark as solution if needed.
		// <button id="${rq.getTrackingId()}" onclick="javascript:markResolved(this.id)" type="submit" class="btn btn-success" value ="Solution" style="float: right; margin: 10px;"  <%= ((String)session.getAttribute("landingpage")).equalsIgnoreCase("WelcomeFacilityHead.jsp") ? "" : "disabled"%> style="display: none;"><span class="glyphicon glyphicon-ok"></span> Mark as a Resolved</button>
		RequestDispatcher rd = request.getRequestDispatcher("GrievanceListView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Called Grievance Post");
		HttpSession session = request.getSession();
		Event event = new Event();
		EventsDao dao = new EventsDao();
		NotificationDao notificationDao = new NotificationDao();
		FacilityHeadDao facilityHeadDao = new FacilityHeadDao();
		UUID uuid = UUID.randomUUID();
		String subject = request.getParameter("subject");
		event.setSubject(subject);
		event.setMessage(request.getParameter("content"));
		event.setFacility(request.getParameter("facility"));
		event.setFrom((String)session.getAttribute("username"));
		event.setEventType("Grievance");
		event.setSerialNo(1);
		String to = facilityHeadDao.getRowByFacility(request.getParameter("facility"));
		event.setTo(to);
		event.setTrackingId(uuid.toString());
		dao.addGrievance(event);
		
		request.setAttribute("message", "Complaint added successfully.");
		
		//Add Notification
		Notification notification = new Notification();
		notification.setRequestId(uuid.toString());
		notification.setSubject("New Grievance Raised");
		notification.setMessage(subject);
		notificationDao.addNotification(notification, to);
		
		RequestDispatcher rd = request.getRequestDispatcher("GrievanceNew.jsp");
		rd.forward(request, response);
	}

}
