package com.confRoomBooking.services;

import java.util.List;

import com.confRoomBooking.models.Event;

public interface EventServiceImpl {
	int addEvent(Event event);

	boolean cancelEvent(int id);

	List<Event> getEvents();
}