package com.confRoomBooking.controllers;

import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.confRoomBooking.models.Event;
import com.confRoomBooking.services.EventService;
import com.confRoomBooking.services.confService;

@Path("event")
public class EventController {
	
	EventService eventService = new EventService();
	
	@POST
	@Path("/add/{confId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addEvent(Event event) {
		int id = eventService.addEvent(event);
		return Response.ok(id).build();
	}
	
	
	@POST
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvents() {
		return Response.ok(eventService.getEvents()).build();
	}
	
	@GET
	@Path("/delete/{eventId}")
	public Response  cancelEvent(@PathParam("eventId") int id) {
		return Response.ok(eventService.cancelEvent(id)).build();
	}
	
	@GET
	@Path("/get/{confId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEventByConfId(@PathParam("confId") int confId) {
		return Response.ok(eventService.getEventByConfId(confId)).build();
	}
}
