package com.ohdgh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ohdgh.model.FacilityHead;
import com.ohdgh.model.Student;

public class FacilityHeadDao {
	public List<FacilityHead> listRows()
	{
		String query = "SELECT [Name], [EmpNo], [Department], [Specialization], [Facility], [Id] FROM [dbo].[FacilityHead]";
		List<FacilityHead> facilityHeads = new ArrayList<FacilityHead>();
		try {
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
                System.out.println(resultSet.getString(1) + " "
                    + resultSet.getString(2));
            }
            connection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return facilityHeads;
	}
	
	public FacilityHead getRow(String empNo) {
		return null;
	}
}
