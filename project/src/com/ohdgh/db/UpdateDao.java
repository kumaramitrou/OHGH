package com.ohdgh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ohdgh.model.Update;

public class UpdateDao {
	public List<Update> list(){
		List<Update> updates = new ArrayList<Update>();
		try {
			String query = "Select [Subject], [Content], [Id] from [dbo].[Update]";
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next())
            {
				Update update = new Update();
				update.setContent(resultSet.getString("Content"));
				update.setSubject(resultSet.getString("Subject"));
				update.setId(resultSet.getLong("Id"));
				updates.add(update);
            }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return updates;
	}
	
	public int getCount() {
		String query = "SELECT Count(Id) as [UpdateCount] from [dbo].[Update]";
		int updateCount = 0;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next())
				updateCount = resultSet.getInt("UpdateCount");
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return updateCount;
	}
	
	public boolean addRow(Update update) {
		boolean isSuccess = false;
		String query = "INSERT INTO [dbo].[Update] ([Subject], [Content]) VALUES (?, ?)";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, update.getSubject());
			stmt.setString(2, update.getContent());
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("Updated Successfully..");
			
			if(rowsUpdated>0)
				isSuccess = true;
			
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}
}
