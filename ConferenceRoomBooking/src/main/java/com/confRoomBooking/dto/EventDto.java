package com.confRoomBooking.dto;


public class EventDto {
	int id;
	String username;

	Long empCode;

	String start;

	String end;
	
	String title;
	
	int confRoomId;
	
	String confRoomName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getEmpCode() {
		return empCode;
	}

	public void setEmpCode(Long empCode) {
		this.empCode = empCode;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getConfRoomId() {
		return confRoomId;
	}

	public void setConfRoomId(int confRoomId) {
		this.confRoomId = confRoomId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getConfRoomName() {
		return confRoomName;
	}

	public void setConfRoomName(String confRoomName) {
		this.confRoomName = confRoomName;
	}
	
	
	
	
	
}
