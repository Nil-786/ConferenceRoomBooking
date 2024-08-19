package com.confRoomBooking.repositories;

import java.util.List;

import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;


public interface EventRepoImpl {
	public int addEvent(Event event) ;
	public Event readEvent(int id);
	public List<Event> readAllEvent();
	public boolean updateEvent(Event event);
	public boolean deleteEvent(int id);
	public List<Event> readEventByConf(ConferenceRoom conf);
	public boolean eventExists(ConferenceRoom conf,Event event) ;
	
}
