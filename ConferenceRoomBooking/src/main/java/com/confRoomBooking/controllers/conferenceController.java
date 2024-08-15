package com.confRoomBooking.controllers;

import java.io.*;
import java.io.InputStream;
import java.util.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.FormDataParam;
import com.confRoomBooking.models.ConfPhotos;
import com.confRoomBooking.models.ConferenceRoom;
import com.confRoomBooking.repositories.ConferenceRoomRepoImpl;
import com.confRoomBooking.services.*;

@Path("conf")
public class conferenceController {
	
	confServiceImpl confService = new confService();
	ConfPhotos cnf = new ConfPhotos();
	List<ConfPhotos> uploadp;
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addConf(ConferenceRoom confRoom) {
		
		int id = confService.addConf(confRoom);
		
		cnf.setConferenceRoom(confRoom);
		confRoom.setPhotos(uploadp);
		confService.addPhoto(cnf);
		
		return Response.ok(id).build();
	}
	
	/*@POST
	@Path("/addPhotos")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPhoto(ConfPhotos photo) {
		confService.addPhoto(photo);
		System.out.println("yes");
		return Response.ok().build();
		
	}*/
	/* first working version1
	@POST
	@Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(InputStream fileInputStream) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            byte[] fileBytes = readInputStream(fileInputStream);
            
            ConfPhotos cnf = new ConfPhotos();
            cnf.setData(fileBytes);
            confService.addPhoto(cnf);
            // extra things
            System.out.println("File size: " + fileBytes.length + " bytes");
            
            resultMap.put("status", "success");
            resultMap.put("message", "File uploaded successfully");
            return Response.ok(resultMap).build();
        } catch (Exception e) {
            resultMap.put("status", "error");
            resultMap.put("message", "Failed to upload file");
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(resultMap).build();
        }
    }

    private byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return buffer.toByteArray();
    }*/
	
	/*upload version 2*/
	@POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFiles(FormDataMultiPart multiPart) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            // Retrieve all file parts
            for (FormDataBodyPart part : multiPart.getFields("photos")) {
                InputStream fileInputStream = part.getValueAs(InputStream.class);
                
                // Read each file into a byte array
                byte[] fileBytes = readInputStream(fileInputStream);

                // Create a new ConfPhotos object
                ConfPhotos cnf = new ConfPhotos();
                cnf.setData(fileBytes);


               

                // Save each ConfPhotos object using the service
                confService.addPhoto(cnf);
            }

            // Respond with a success message
            resultMap.put("status", "success");
            resultMap.put("message", "Files uploaded and photos saved successfully");
            return Response.ok(resultMap).build();
        } catch (Exception e) {
            resultMap.put("status", "error");
            resultMap.put("message", "Failed to upload files and save photos");
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(resultMap).build();
        }
    }

    // Helper method to read InputStream to byte[]
    private byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return buffer.toByteArray();
    }
}
	
	 


