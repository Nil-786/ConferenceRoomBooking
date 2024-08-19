package com.confRoomBooking.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.confRoomBooking.dto.EventDto;
import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;
import com.confRoomBooking.repositories.EventRepo;

public class EventService implements EventServiceImpl{
	EventRepo repo;
	confServiceImpl confServ;
	

	public EventService() {
		this.repo = new EventRepo();
		this.confServ = new confService();
	}


	@Override
	public int addEvent(EventDto eventDto) {
		Event event  = new Event();
		ConferenceRoom room = confServ.getConf(eventDto.getConfRoomId());

		LocalDateTime endTime = LocalDateTime.parse(eventDto.getEnd());
		LocalDateTime startTime = LocalDateTime.parse(eventDto.getStart());

		event.setTitle(eventDto.getTitle());
		event.setEmpCode(eventDto.getEmpCode());

		event.setStart(startTime);
		event.setEnd(endTime);
		event.setUsername(eventDto.getUsername());
		event.setConferenceRoom(room);
		if(!eventExists(room, event)) {
			return repo.addEvent(event);
		}
		return -1;
	}

	@Override
	public List<EventDto> getEvents() {
		List<Event> events = repo.readAllEvent();
		List<EventDto> eventDto = events.stream().map((eve) -> {
		    EventDto dto = new EventDto();
		    dto.setId(eve.getId());
		    dto.setTitle(eve.getTitle());
		    dto.setStart(eve.getStart().toString());
		    dto.setEnd(eve.getEnd().toString());
		    dto.setConfRoomId(eve.getConferenceRoom().getId());
		    dto.setConfRoomName(eve.getConferenceRoom().getName());
		    dto.setUsername(eve.getUsername());
		    dto.setEmpCode(eve.getEmpCode());
		    return dto;
		}).collect(Collectors.toList());
		
		return eventDto;
	}

	@Override
	public boolean cancelEvent(int id) {
		return repo.deleteEvent(id);
	}

	public Event getEvent(int id) {
		return repo.readEvent(id);
	}

	public List<Event> getEventByConfId(int confId) {
		return repo.readEventByConf(confServ.getConf(confId));
	}


	@Override
	public boolean eventExists(ConferenceRoom room, Event event) {
		return repo.eventExists(room, event);
	}



	

}