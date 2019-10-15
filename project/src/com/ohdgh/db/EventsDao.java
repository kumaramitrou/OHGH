package com.ohdgh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ohdgh.model.Event;

public class EventsDao {
	public boolean addRequest(Event event) {
		boolean isSuccess = false;
		String query = "Insert into [dbo].[Events] ([Subject],[Message],[SerialNo],[Facility],[EventType],[TrackingId],[From],[To]) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, event.getSubject());
			stmt.setString(2, event.getMessage());
			stmt.setInt(3, 1);
			stmt.setString(4, event.getFacility());
			stmt.setString(5, event.getEventType());
			stmt.setString(6, event.getTrackingId());
			stmt.setString(7, event.getFrom());
			stmt.setString(8, event.getTo());
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("Added Successfully..");
			
			if(rowsUpdated>0)
				isSuccess = true;
			
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}

	public List<Event> listAllRequests(String userName, boolean from){
		String fromQuery = "select * from [dbo].[Events] where [SerialNo] = 1 and [EventType] = ? and [From] = ?";
		String toQuery = "select * from [dbo].[Events] where [SerialNo] = 1 and [EventType] = ? and [To] = ?";
		String query = from ? fromQuery : toQuery ;
		List<Event> allRequests = new ArrayList<Event>();
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, "Request");
			stmt.setString(2, userName);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Event req = new Event();
				req.setId(rs.getLong("Id"));
				req.setDocumentUrl(rs.getString("DocumentUrl"));
				req.setEventType(rs.getString("EventType"));
				req.setFacility(rs.getString("Facility"));
				req.setFrom(userName);
				req.setMessage(rs.getString("Message"));
				req.setSubject(rs.getString("Subject"));
				req.setTrackingId(rs.getString("TrackingId"));
				allRequests.add(req);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allRequests;
	}
	
	public List<Event> listOpenRequests(String userName, boolean from){
		String fromQuery = "select * from [dbo].[Events] where [TrackingId] not in (select [TrackingId] from [dbo].[Events] where [EventType] in ('Solution','Grievance')) and [SerialNo] = 1 and [EventType] = 'Request' and [From] = ?";
		String toQuery = "select * from [dbo].[Events] where [TrackingId] not in (select [TrackingId] from [dbo].[Events] where [EventType] in ('Solution','Grievance')) and [SerialNo] = 1 and [EventType] = 'Request' and [To] = ?";
		String query = from ? fromQuery : toQuery;
		List<Event> allRequests = new ArrayList<Event>();
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Event req = new Event();
				req.setId(rs.getLong("Id"));
				req.setDocumentUrl(rs.getString("DocumentUrl"));
				req.setEventType(rs.getString("EventType"));
				req.setFacility(rs.getString("Facility"));
				req.setFrom(userName);
				req.setMessage(rs.getString("Message"));
				req.setSubject(rs.getString("Subject"));
				req.setTrackingId(rs.getString("TrackingId"));
				allRequests.add(req);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allRequests;
	}
	
	public List<Event> listRequestHistory(String userName, String trackingId){
		String query = "select * from [dbo].[Events] where [TrackingId] = ? order by [SerialNo]";
		List<Event> allRequests = new ArrayList<Event>();
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, trackingId);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Event req = new Event();
				req.setId(rs.getLong("Id"));
				req.setDocumentUrl(rs.getString("DocumentUrl"));
				req.setEventType(rs.getString("EventType"));
				req.setFacility(rs.getString("Facility"));
				req.setFrom(rs.getString("From"));
				req.setTo(rs.getString("To"));
				req.setMessage(rs.getString("Message"));
				req.setSubject(rs.getString("Subject"));
				req.setTrackingId(rs.getString("TrackingId"));
				req.setSerialNo(rs.getInt("SerialNo"));
				req.setDesign(getEventDesign(userName, req.getFrom()));
				allRequests.add(req);
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return allRequests;
	}
	
	public String getEventDesign(String userName, String from) {
		if(userName.equalsIgnoreCase(from))
			return "panel panel-success";
		else
			return "panel panel-warning";
	}
	
	public boolean hasSolution(String trackingId) {
		boolean isExist = false;
		String query = "Select * from [dbo].[Events] where [TrackingId] = ? and [EventType] = 'Solution'";
		try {
			System.out.println("Inside hasSolution");
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, trackingId);
			ResultSet rs = stmt.executeQuery();
			isExist = rs.next();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isExist;
	}
	
	public boolean addReply(Event reply) {
		boolean isSuccess = false;
		String query = "Insert into [dbo].[Events] ([Subject],[Message],[SerialNo],[Facility],[EventType],[TrackingId],[From],[To]) values (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, reply.getSubject());
			stmt.setString(2, reply.getMessage());
			stmt.setInt(3, getSerialNo(reply.getTrackingId()));
			stmt.setString(4, reply.getFacility());
			stmt.setString(5, reply.getEventType());
			stmt.setString(6, reply.getTrackingId());
			stmt.setString(7, reply.getFrom());
			stmt.setString(8, reply.getTo());
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("Reply added Successfully..");
			
			if(rowsUpdated>0)
				isSuccess = true;
			
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public Event getFirstRequest(String trackingId) {
		Event event = new Event();
		String query = "select * from [dbo].[Events] where [TrackingId] = ? and [SerialNo] = 1";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, trackingId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				event.setId(rs.getLong("Id"));
				event.setDocumentUrl(rs.getString("DocumentUrl"));
				event.setEventType(rs.getString("EventType"));
				event.setFacility(rs.getString("Facility"));
				event.setFrom(rs.getString("From"));
				event.setTo(rs.getString("To"));
				event.setMessage(rs.getString("Message"));
				event.setSubject(rs.getString("Subject"));
				event.setTrackingId(rs.getString("TrackingId"));
				event.setSerialNo(rs.getInt("SerialNo"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return event;
	}
	
	/**
	 * @param trackingId
	 * @return
	 */
	private int getSerialNo(String trackingId) {
		String query = "select Max([SerialNo])+1 as [Serial] from [dbo].[Events] where [TrackingId] = ?";
		int serialNo = 0;
		try {
			System.out.println("SerialNo : "+serialNo);
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, trackingId);
			ResultSet rs = stmt.executeQuery();
			serialNo = rs.next() ? rs.getInt("Serial") : 1;
			System.out.println("SerialNo : "+serialNo);
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return serialNo;
	}
}
