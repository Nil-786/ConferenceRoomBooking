package com.confRoomBooking.services;

import java.util.List;

import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;
import com.confRoomBooking.repositories.EventRepo;

public class EventService implements EventServiceImpl{
	EventRepo repo;
	
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
	
	public List<Event> getEventByConfId(ConferenceRoom conf) {
		
		return repo.readEventByConf(conf);
	}
}
