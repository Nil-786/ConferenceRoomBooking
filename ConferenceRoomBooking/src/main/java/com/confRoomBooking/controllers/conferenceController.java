package com.confRoomBooking.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.confRoomBooking.models.ConfPhotos;
import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.repositories.ConferenceRoomRepoImpl;
import com.confRoomBooking.services.*;

@Path("conf")
public class conferenceController {
	
	confServiceImpl confService = new confService();
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addConf(ConferenceRoom confRoom) {
		int id = confService.addConf(confRoom);
		return Response.ok(id).build();
	}
	
	@POST
	@Path("/addPhoto")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPhoto(ConfPhotos photo) {
		confService.addPhoto(photo);
		return Response.ok().build();
	}
}
