package com.ohdgh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.ohdgh.model.Notification;

public class NotificationDao {

	public List<Notification> getByUserName(String userName){
		List<Notification> notifications = new ArrayList<Notification>();
		String query = "SELECT [RequestId], [Message], [Subject] from [dbo].[Notification] where [UserName] = ? and [IsViewed] = 0";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, userName);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next())
            {
				Notification notif = new Notification();
				notif.setMessage(resultSet.getString("Message"));
				notif.setRequestId(resultSet.getString("RequestId"));
				notif.setSubject(resultSet.getString("Subject"));
				notifications.add(notif);
            }
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return notifications;
	}
	
	public int getCount(String userName) {
		String query = "SELECT Count(Id) as [NotificationCount] from [dbo].[Notification] where [UserName] = ? and [IsViewed] = 0";
		int notificationCount = 0;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, userName);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next())
				notificationCount = resultSet.getInt("NotificationCount");
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return notificationCount;
	}
	
	public boolean resetNotification(String userName) {
		String query = "UPDATE [dbo].[Notification] SET [IsViewed] = 1 WHERE [UserName] = ? and [IsViewed] = 0";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, userName);
			stmt.executeUpdate();
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean addNotification(Notification notification) {
		return true;
	}
}
