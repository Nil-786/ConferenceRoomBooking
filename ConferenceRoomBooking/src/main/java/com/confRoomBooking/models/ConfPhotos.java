package com.confRoomBooking.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class ConfPhotos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Lob
	private byte[] data;
	
	@ManyToOne
	@JoinColumn(name = "conf_room_id")
	private ConferenceRoom conferenceRoom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public ConferenceRoom getConferenceRoom() {
		return conferenceRoom;
	}

	public void setConferenceRoom(ConferenceRoom conferenceRoom) {
		this.conferenceRoom = conferenceRoom;
	}
	
}
