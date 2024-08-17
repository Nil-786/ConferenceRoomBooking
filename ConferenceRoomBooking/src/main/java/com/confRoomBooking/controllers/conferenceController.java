package com.confRoomBooking.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.confRoomBooking.models.ConfPhotos;
import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.repositories.ConferenceRoomRepoImpl;
import com.confRoomBooking.services.*;

@Path("conf")
public class conferenceController {

	confService confService = new confService();

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addConf(ConferenceRoom confRoom) {
		confRoom.setPhotos(confService.getPhotos());
		int id = confService.addConf(confRoom);
		return Response.ok(id).build();
	}

	/* first working version1 */
	@POST
	@Path("/addPhoto")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(InputStream fileInputStream) {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			byte[] fileBytes =confService.readInputStream(fileInputStream);

			ConfPhotos cnf = new ConfPhotos();
			cnf.setData(fileBytes);
			confService.addPhoto(cnf);
			System.out.println("File size: " + cnf.getData().length + " bytes");

			resultMap.put("status", "success");
			resultMap.put("message", "File uploaded successfully");
			return Response.ok(resultMap).build();
		} catch (Exception e) {
			resultMap.put("status", "error");
			resultMap.put("message", "Failed to upload file");
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(resultMap).build();
		}
	}


}
