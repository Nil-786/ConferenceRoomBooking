package com.confRoomBooking.services;

import java.util.List;

import com.confRoomBooking.dto.EventDto;
import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;

public interface EventServiceImpl {
	int addEvent(EventDto eventDto);
	boolean cancelEvent(int id);
	List<EventDto> getEvents();
	public List<Event> getEventByConfId(int confId);
	boolean eventExists(ConferenceRoom room ,Event event);
}