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

import com.confRoomBooking.dto.EventDto;
import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.models.Event;
import com.confRoomBooking.services.EventService;
import com.confRoomBooking.services.EventServiceImpl;
import com.confRoomBooking.services.confService;
import com.confRoomBooking.services.confServiceImpl;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;

@Path("event")
public class EventController {

	EventServiceImpl eventService = new EventService();
	confServiceImpl conf = new confService();

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEvent(EventDto eventDto) {

		int id = eventService.addEvent(eventDto);
		if(id!=-1) {
			return Response.ok(id).build();
		}
		
		return Response.serverError().build();
	}


	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents() {
		List<EventDto> list = eventService.getEvents();
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
		GenericEntity entity = new GenericEntity<List<Event>>(list){};

		return Response.ok(entity).build();
	}
}