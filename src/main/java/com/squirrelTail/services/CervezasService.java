package com.squirrelTail.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.squirrelTail.models.StatusMessage;
import com.squirrelTail.persistencia.CervezaManager;

@Path("/cervezas")
public class CervezasService {

	@GET
	@Produces("application/json")
	public Response getCervezas() {

		CervezaManager cm;
		try {
			cm = CervezaManager.getInstance();

			return Response.status(200).entity(cm.getCervezas()).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}

	@Path("/{zid}")
	@GET
	@Produces("application/json")
	public Response getCervezas(@PathParam("zid") int zid) {

		CervezaManager cm;
		try {
			cm = CervezaManager.getInstance();

			return Response.status(200).entity(cm.getCerveza(zid)).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}
	
}
