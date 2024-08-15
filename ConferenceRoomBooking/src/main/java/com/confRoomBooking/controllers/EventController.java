package com.confRoomBooking.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.confRoomBooking.models.Event;
import com.confRoomBooking.services.EventService;
import com.confRoomBooking.services.confService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Path("event")
public class EventController {
	
	EventService eventService = new EventService();
	confService conf = new confService();
	
	@POST
	@Path("/{confId}/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEvent(@PathParam("confId") int confId,Event event) {
		event.setConferenceRoom(conf.getConf(confId));
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
		List<Event> list = eventService.getEventByConfId(conf.getConf(confId));
		return Response.ok(list).build();
	}
}
