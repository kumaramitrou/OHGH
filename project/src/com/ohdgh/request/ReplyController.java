package com.ohdgh.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.EventsDao;
import com.ohdgh.db.NotificationDao;
import com.ohdgh.model.Event;
import com.ohdgh.model.Notification;

@WebServlet("/Reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String trackingId = request.getParameter("trackingid");
		System.out.println("Tracking Id is : "+ trackingId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String trackingId = request.getParameter("trackingid");
		System.out.println("Tracking Id is : "+ trackingId);
		
		HttpSession session = request.getSession();
		EventsDao eventDao = new EventsDao();
		Event reply = new Event();
		Event firstRequest = eventDao.getFirstRequest(trackingId);
		
		String sub = request.getParameter("subject");
		String message = request.getParameter("content");
		String username = (String)session.getAttribute("username");
		System.out.println("Subject : "+sub+" Content : "+ message);

		reply.setTrackingId(trackingId);
		reply.setMessage(message);
		reply.setSubject(sub);
		reply.setFrom(username);
		reply.setFacility(firstRequest.getFacility());
		reply.setEventType("Reply");
		
		if (firstRequest.getFrom().equalsIgnoreCase(username)) {
			reply.setTo(firstRequest.getTo());
		}
		else {
			reply.setTo(firstRequest.getFrom());
		}
		eventDao.addReply(reply);
		
		// Add Notification
		NotificationDao notificationDao = new NotificationDao();
		Notification notification = new Notification();
		notification.setRequestId(trackingId);
		notification.setSubject("Got a Reply.");
		notification.setMessage(sub);
		notificationDao.addNotification(notification, reply.getTo());
		
		RequestDispatcher rd = request.getRequestDispatcher("Show?trackingid="+trackingId);
		rd.forward(request,response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
