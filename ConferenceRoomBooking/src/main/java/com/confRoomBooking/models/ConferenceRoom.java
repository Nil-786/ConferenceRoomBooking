package com.confRoomBooking.models;

import java.util.List;

import javax.persistence.*;


@Entity
public class ConferenceRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	
	int capacity;
	
	@OneToMany(mappedBy = "conferenceRoom", cascade = CascadeType.ALL)
	private List<ConfPhotos> photos;
	
	@OneToMany(mappedBy = "conferenceRoom",cascade = CascadeType.ALL)
	private List<Event> events;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<ConfPhotos> getPhotos() {
		return photos;
	}

	public void setPhotos(List<ConfPhotos> photos) {
		this.photos = photos;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	} 
	
}
