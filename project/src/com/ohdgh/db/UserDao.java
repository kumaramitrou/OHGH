package com.ohdgh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.ohdgh.model.User;

public class UserDao {
	public List<User> listUsers()
	{
		return null;
	}
	
	public boolean addUser(User user)
	{
		boolean isSuccess = false;
		String query = "INSERT INTO [dbo].[User] ([Name], [Email], [Password], [Question], [Answer], [Status], [HomePage], [UserName], [UID]) VALUES (?, ?, ?, ?, ?, 1, ?, ?, ?)";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getQuestion());
			stmt.setString(5, user.getAnswer());
			stmt.setString(6, user.getType());
			stmt.setString(7, user.getUserName());
			stmt.setString(8, user.getUid());
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("User Added Successfully..");
			
			if(rowsUpdated>0)
				isSuccess = true;
			
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public boolean checkCredential(String uname, String password)
	{
		String query = "select * from [dbo].[User] where [UserName] = ? and [Password] = ?";
		boolean credCorrect = false;
		try {
			
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, uname);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
			credCorrect = rs.next();
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return credCorrect;
	}
	
	public boolean isExist(String uname)
	{
		String query = "select * from [dbo].[User] where [UserName] = ?";
		boolean userExist = false;
		try {
			
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, uname);
			
			ResultSet rs = st.executeQuery();
			
			userExist = rs.next();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userExist;
	}
	
	public String userLandingPage(String uname)
	{
		String query = "select [HomePage] from [dbo].[User] where [UserName] = ?";
		String landingPage = null;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, uname);
			
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				landingPage = rs.getString(1);
				System.out.println(landingPage);
			}
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return landingPage;
	}
	
	public boolean isEmailExist(String userEmail) {
		String query = "SELECT [Id] FROM [dbo].[User] where [Email] = ?";
		boolean emailExist = false;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, userEmail);
			
			ResultSet rs = stmt.executeQuery();
			
			emailExist = rs.next();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return emailExist;
	}
	
	public boolean isUserNameExist(String userName) {
		String query = "SELECT [Id] FROM [dbo].[User] where [UserName] = ?";
		boolean userNameExist = false;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, userName);
			
			ResultSet rs = stmt.executeQuery();
			
			userNameExist = rs.next();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userNameExist;
	}
	
	public boolean isUIDExist(String uid) {
		String query = "SELECT [Id] FROM [dbo].[User] where [UID] = ?";
		boolean uidExist = false;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = con.prepareStatement(query);
			
			stmt.setString(1, uid);
			
			ResultSet rs = stmt.executeQuery();
			
			uidExist = rs.next();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return uidExist;
	}

	public boolean removeUserByUid(String uid) {
		boolean isSuccess = false;
		String query = "DELETE FROM [dbo].[User] WHERE [UID] = ?";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, uid);
			System.out.println(query);
			
			int rowsUpdated = stmt.executeUpdate();
		System.out.println(rowsUpdated);
			
			if(rowsUpdated>0) {
				
				System.out.println("Deleted Successfully");
				isSuccess = true;
			}
			
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public boolean changePassword(String userName, String password) {
		boolean passwordChanged = false;
		try {
			String query = "UPDATE [dbo].[User] SET Password = ? WHERE [UserName] = ?";
			
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, password);
			stmt.setString(2, userName);
			
			passwordChanged = stmt.executeUpdate() > 0;
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return passwordChanged;
	}
}
