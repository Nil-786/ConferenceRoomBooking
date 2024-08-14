package com.confRoomBooking.controllers;

import java.io.IOException;
import java.net.URI;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.confRoomBooking.models.User;
import com.confRoomBooking.services.*;

@Path("user")
public class UserController {

	UserServiceImpl userService = new userService();

	@POST()
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUser(User user) {
		int id = userService.addUser(user);
		return Response.ok(id).build();
	}

	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUser(@QueryParam("uName") String userName, @QueryParam("pass") String pass,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {
		User user = userService.userLogin(userName, pass);
		if (user.getUserName() != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			return Response.temporaryRedirect(URI.create("/ConferenceRoomBooking/jsp/Home.jsp")).build();
		}
		return Response.temporaryRedirect(URI.create("/ConferenceRoomBooking/")).build();

	}
}
