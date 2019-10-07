package com.ohdgh.model;

public class FacilityHead {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String name;
	private String empNo;
	private String department;
	private String specialization;
	private String facility;
	private long id;
	
	@Override
	public String toString() {
		return "<td>" + empNo + "</td><td>" + name + "</td><td>" + department + "</td><td>" + specialization + "</td><td>" + facility + "</td>";
	}
}
