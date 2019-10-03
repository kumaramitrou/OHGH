package com.ohdgh.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ohdgh.model.Student;

public class StudentDao {
	public List<Student> listRows()
	{
		List<Student> students = new ArrayList<Student>();
		String query = "Select [RollNo], [Name], [Batch], [Stream], [Id] from [dbo].[Student]";
		try {
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next())
            {
				Student student = new Student();
				student.setRollNo(resultSet.getString("RollNo"));
				student.setName(resultSet.getString("Name"));
				student.setBatch(resultSet.getString("Batch"));
				student.setStream(resultSet.getString("Stream"));
				student.setId(resultSet.getLong("Id"));
				students.add(student);
                System.out.println(resultSet.getString(1) + " "
                    + resultSet.getString(2));
            }
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return students;
	}
	
	public Student getRow(String rollNo) {
		String query = "SELECT * FROM [dbo].[Student] WHERE [RollNo] = ?";
		Student student = null;
		try {
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, rollNo);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("Fetched Successfully.. ");
				student = new Student();
				student.setId(rs.getLong("Id"));
				student.setName(rs.getString("Name"));
				student.setRollNo(rs.getString("RollNo"));
				student.setBatch(rs.getString("Batch"));
				student.setStream(rs.getString("Stream"));
			}
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return student;
	}
	
	public boolean addRow(Student student) {
		boolean isSuccess = false;
		String query = "INSERT INTO [dbo].[Student] ([RollNo], [Name], [Batch], [Stream]) VALUES (?, ?, ?, ?)";
		try {
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, student.getRollNo());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getBatch());
			stmt.setString(4, student.getStream());
			
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
}
