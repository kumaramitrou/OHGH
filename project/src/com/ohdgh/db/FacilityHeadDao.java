package com.ohdgh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ohdgh.model.FacilityHead;

public class FacilityHeadDao {
	public List<FacilityHead> listRows()
	{
		String query = "SELECT [Name], [EmpNo], [Department], [Specialization], [Facility], [Id] FROM [dbo].[FacilityHead]";
		List<FacilityHead> facilityHeads = new ArrayList<FacilityHead>();
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next())
            {
				FacilityHead facilityHead = new FacilityHead();
				facilityHead.setEmpNo(resultSet.getString("EmpNo"));
				facilityHead.setName(resultSet.getString("Name"));
				facilityHead.setDepartment(resultSet.getString("Department"));
				facilityHead.setSpecialization(resultSet.getString("Specialization"));
				facilityHead.setFacility(resultSet.getString("Facility"));
				facilityHead.setId(resultSet.getLong("Id"));
				facilityHeads.add(facilityHead);
            }
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return facilityHeads;
	}
	
	public FacilityHead getRowByEmpNo(String empNo) {
		String query = "SELECT * FROM [dbo].[FacilityHead] WHERE [EmpNo] = ?";
		FacilityHead facilityHead = null;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, empNo);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("Fetched Successfully.. ");
				facilityHead = new FacilityHead();
				facilityHead.setId(rs.getLong("Id"));
				facilityHead.setName(rs.getString("Name"));
				facilityHead.setDepartment(rs.getString("Department"));
				facilityHead.setEmpNo(rs.getString("EmpNo"));
				facilityHead.setFacility(rs.getString("Facility"));
				facilityHead.setSpecialization(rs.getString("Specialization"));
			}
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return facilityHead;
	}
	
	public FacilityHead getRowById(String id) {
		String query = "SELECT * FROM [dbo].[FacilityHead] WHERE [Id] = ?";
		FacilityHead facilityHead = null;
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("Fetched Successfully.. ");
				facilityHead = new FacilityHead();
				facilityHead.setId(rs.getLong("Id"));
				facilityHead.setName(rs.getString("Name"));
				facilityHead.setDepartment(rs.getString("Department"));
				facilityHead.setEmpNo(rs.getString("EmpNo"));
				facilityHead.setFacility(rs.getString("Facility"));
				facilityHead.setSpecialization(rs.getString("Specialization"));
			}
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return facilityHead;
	}
	
	public boolean addRow(FacilityHead facilityHead) {
		boolean isSuccess = false;
		String query = "INSERT INTO [dbo].[FacilityHead] ([Name], [EmpNo], [Department], [Specialization], [Facility]) VALUES (?, ?, ?, ?, ?)";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, facilityHead.getName());
			stmt.setString(2, facilityHead.getEmpNo());
			stmt.setString(3, facilityHead.getDepartment());
			stmt.setString(4, facilityHead.getSpecialization());
			stmt.setString(5, facilityHead.getFacility());
			
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
	
	public boolean removeRow(String id) {
		boolean isSuccess = false;
		String query = "DELETE FROM [dbo].[FacilityHead] WHERE Id = ?";
		try {
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, id);
			
			int rowsUpdated = stmt.executeUpdate();
			System.out.println("Deleted Successfully");
			
			if(rowsUpdated>0)
				isSuccess = true;
			
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return isSuccess;
	}
	
	public boolean distinctFacility(String facilityName) {
		boolean isDistinct = true;
		try {
			String query = "Select [Id] from [dbo].[FacilityHead] where [Facility] = ?";
			Class.forName(DatabaseCredentials.driver);
			Connection connection = DriverManager.getConnection(DatabaseCredentials.url);
			PreparedStatement stmt = connection.prepareStatement(query);
			
			stmt.setString(1, facilityName);
			
			ResultSet rs = stmt.executeQuery();
			
			isDistinct = !rs.next();
			
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return isDistinct;
	}
}
