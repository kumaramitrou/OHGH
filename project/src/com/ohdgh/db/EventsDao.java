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

	public List<Event> listAllRequests(String userName){
		String query = "select * from [dbo].[Events] where [SerialNo] = 1 and [EventType] = ? and [From] = ?";
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
	
	public List<Event> listOpenRequests(String userName){
		String query = "select * from [dbo].[Events] where [TrackingId] not in (select [TrackingId] from [dbo].[Events] where [EventType] in ('Solution','Grievance')) and [SerialNo] = 1 and [EventType] = 'Request' and [From] = ?";
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
}
