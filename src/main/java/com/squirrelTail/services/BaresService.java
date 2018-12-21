package com.squirrelTail.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.squirrelTail.models.StatusMessage;
import com.squirrelTail.persistencia.BarManager;

@Path("/bares")
public class BaresService {

	@GET
	@Produces("application/json")
	public Response getBares() {

		BarManager bm;
		try {
			bm = BarManager.getInstance();

			return Response.status(200).entity(bm.getBares()).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}

	@Path("/{nid}")
	@GET
	@Produces("application/json")
	public Response getBares(@PathParam("nid") int nid) {

		BarManager bm;
		try {
			bm = BarManager.getInstance();

			return Response.status(200).entity(bm.getBar(nid)).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}
}
