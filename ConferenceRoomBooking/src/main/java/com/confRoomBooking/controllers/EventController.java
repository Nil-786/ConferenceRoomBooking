package com.confRoomBooking.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;
import com.confRoomBooking.services.EventService;
import com.confRoomBooking.services.confService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Path("event")
public class EventController {
	
	EventService eventService = new EventService();
	confService conf = new confService();
	
	@GET
	@Path("/{confId}/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEvent(@PathParam("confId") int confId,@QueryParam("employeeId") long empCode,@QueryParam("employeeName") String empName, 
							@QueryParam("startTime") String start,@QueryParam("endTime") String end,@QueryParam("eventTitle") String title) {
		Event event  = new Event();
		ConferenceRoom room = conf.getConf(confId);
		if(room == null) {
			throw new WebApplicationException("room not present",Response.Status.BAD_REQUEST);
		}
		
		LocalDateTime endTime = LocalDateTime.parse(end);
		LocalDateTime startTime = LocalDateTime.parse(start);
		
		event.setTitle(title);
		event.setEmpCode(empCode);
		
		event.setStart(LocalDateTime.parse(start));
		event.setUsername(empName);
		event.setConferenceRoom(room);
		Event oldEvent = eventService.checkEvent(event);
		
		if(oldEvent != null) {
			throw new WebApplicationException("conflicting already booked events!!",Response.ok(oldEvent).build());
		}
		
		int id = eventService.addEvent(event);
		return Response.ok(id).build();
	}
	
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents() {
		List<Event> list = eventService.getEvents();
		GenericEntity entity = new GenericEntity<List<Event>>(list){};
		 
		return Response.ok(entity).build();
	}
	
	@GET
	@Path("/delete/{eventId}")
	public Response  cancelEvent(@PathParam("eventId") int id) {
		return Response.ok(eventService.cancelEvent(id)).build();
	}
	
	@GET
	@Path("/{confId}/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEventByConfId(@PathParam("confId") int confId) {
		List<Event> list = eventService.getEventByConfId(confId);
		GenericEntity entity = new GenericEntity<List<Event>>(list){};
		
		return Response.ok(entity).build();
	}
}
