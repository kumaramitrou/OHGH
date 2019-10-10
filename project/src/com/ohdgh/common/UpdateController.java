package com.ohdgh.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ohdgh.db.UpdateDao;
import com.ohdgh.model.Update;

@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UpdateDao dao = new UpdateDao();
		
		session.setAttribute("update", "");
		
		List<Update> updates = dao.list();
		
		if(updates.isEmpty())
			request.setAttribute("message", "No Updates.");
		
		session.setAttribute("updates", updates);
		RequestDispatcher rd = request.getRequestDispatcher("UpdatesView.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("UpdatesNew.jsp");
		try {
			UpdateDao dao = new UpdateDao();
			//add student
			Update update = new Update();
			update.setContent(request.getParameter("content"));
			update.setSubject(request.getParameter("subject"));
				
			dao.addRow(update);
				
				request.setAttribute("message", "Update saved successfully.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "Oops, Something went wrong!");
		}
		rd.forward(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
