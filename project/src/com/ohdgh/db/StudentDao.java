package com.ohdgh.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.ohdgh.model.Student;
import com.ohdgh.model.User;

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
		return null;
	}
	
	public boolean addRow(Student student) {
		return true;
	}
}
