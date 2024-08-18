package com.confRoomBooking.services;

import java.util.List;

import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;
import com.confRoomBooking.repositories.ConferenceRoomRepo;
import com.confRoomBooking.repositories.EventRepo;

public class EventService implements EventServiceImpl{
	EventRepo repo;
	ConferenceRoomRepo confRepo;
	
	public EventService() {
		this.repo = new EventRepo();
	}
	
	
	@Override
	public int addEvent(Event event) {
		return repo.addEvent(event);
	}

	@Override
	public List<Event> getEvents() {
		List<Event> events = repo.readAllEvent();
		return events;
	}
	
	@Override
	public boolean cancelEvent(int id) {
		return repo.deleteEvent(id);
	}
	
	public Event getEvent(int id) {
		return repo.readEvent(id);
	}
	
	public List<Event> getEventByConfId(int confId) {
		return repo.readEventByConf(confId);
	}
	
	public boolean checkEvent(Event event) {
		return repo.isEventByConf(event);
	}
	
}
