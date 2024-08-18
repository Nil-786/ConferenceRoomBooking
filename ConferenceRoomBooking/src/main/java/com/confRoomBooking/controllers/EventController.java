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
			System.out.println("room error");
			throw new WebApplicationException("room not present",Response.Status.BAD_REQUEST);
		}
		
		LocalDateTime endTime = LocalDateTime.parse(end);
		LocalDateTime startTime = LocalDateTime.parse(start);
		
		event.setTitle(title);
		event.setEmpCode(empCode);
		event.setStart(startTime);
		event.setEnd(endTime);
		event.setUsername(empName);
		event.setConferenceRoom(room);
		eventService.checkEvent(event);
		
		if(!eventService.checkEvent(event)) {
			System.out.println("old event");
			throw new WebApplicationException("conflicting already booked events!!",Response.Status.CONFLICT);
		}
		
		int id = eventService.addEvent(event);
		return Response.ok(id).build();
	}
	
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents() {
		List<Event> list = eventService.getEvents();
		return Response.ok(list).build();
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
		return Response.ok(list).build();
	}
}
