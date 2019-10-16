package com.ohdgh.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.EventsDao;
import com.ohdgh.model.Event;

@WebServlet("/Show")
public class ShowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String trackingId = request.getParameter("trackingid");
		String username = (String)session.getAttribute("username");
		System.out.println(trackingId);
		EventsDao eventsDao = new EventsDao();
		List<Event> requestHistory = eventsDao.listRequestHistory(username, trackingId);
		if(eventsDao.hasSolution(trackingId)) {
			request.setAttribute("divVisibility", "hidden");
			request.setAttribute("solutionVisibility", "visible");
		}
		else {
			request.setAttribute("divVisibility", "visible");
			request.setAttribute("solutionVisibility", "hidden");
		}

		request.setAttribute("trackingid", trackingId);
		request.setAttribute("requesthistory", requestHistory);//((String)session.getAttribute("username"), from));
		RequestDispatcher rd = request.getRequestDispatcher("RequestView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
