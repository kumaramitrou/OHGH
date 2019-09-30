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
		return false;
	}
	
	public boolean checkCredential(String uname, String password)
	{
		System.out.println("Inside Check Credentials");
		System.out.println(uname + " " + password);
		String query = "select * from [dbo].[User] where [UserName] = ? and [Password] = ?";
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, uname);
			st.setString(2, password);
			
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println("Leaving UserDao");
		return false;
	}
	
	public boolean isExist(String uname)
	{
		String query = "select * from [dbo].[User] where [UserName] = ?";
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, uname);
			
			ResultSet rs = st.executeQuery();
			
			return rs.next();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
