package com.harish.messenger.servlet;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.harish.messenger.reqResponsePojos.ProfileReq;
import com.harish.messenger.service.ProfileService;

@Path("profiles")
public class MessengerResource {
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createProfile(ProfileReq profileData) {
		try {
			ProfileService service=new ProfileService();

			if(service.checkProfile(profileData.getProfileName()))
				service.addProfile(profileData.getProfileName(),profileData.getFirstName(),profileData.getLastName());
			return Response.ok().build();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("error");
			return Response.status(414).build();
		}
	}
}
