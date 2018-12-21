package com.squirrelTail.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.squirrelTail.models.Clan;
import com.squirrelTail.models.StatusMessage;
import com.squirrelTail.persistencia.ClanManager;

@Path("/clanes")
public class ClanesService {
	@GET
	@Produces("application/json")
	public Response getClanes() {

		ClanManager cm;
		try {
			cm = ClanManager.getInstance();

			return Response.status(200).entity(cm.getClanes()).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addClan(Clan clanNuevo) {
		Response resp = null;

		if (clanNuevo.validate()) {
			ClanManager cm;
			try {
				cm = ClanManager.getInstance();

				resp = Response.status(200).entity(cm.createClan(clanNuevo)).build();
			} catch (Exception e) {
				e.printStackTrace();

				resp = Response.status(500).entity(new StatusMessage(500, "error")).build();
			}
		} else {
			resp = Response.status(400).entity(new StatusMessage(400, "Clan incompleto")).build();
		}

		return resp;
	}

	@Path("/{cid}")
	@GET
	@Produces("application/json")
	public Response getUsuarios(@PathParam("cid") int cid) {

		ClanManager cm;
		try {
			cm = ClanManager.getInstance();

			return Response.status(200).entity(cm.getClan(cid)).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}

}
