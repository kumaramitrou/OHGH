package com.ohdgh.model;

public class Student {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String name;
	private String rollNo;
	private String batch;
	private String stream;
	private long id;
	@Override
	public String toString() {
		return "<td>" + rollNo + "</td> <td>" + name + "</td> <td>" + batch + "</td> <td>" + stream + "</td>";
	}
}
