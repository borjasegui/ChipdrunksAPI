package com.squirrelTail.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.squirrelTail.models.StatusMessage;
import com.squirrelTail.models.Usuario;
import com.squirrelTail.persistencia.UsuarioManager;

@Path("/usuarios")
public class UsuariosService {

	@GET
	@Produces("application/json")
	public Response getUsuarios() {

		UsuarioManager um;
		try {
			um = UsuarioManager.getInstance();

			return Response.status(200).entity(um.getUsuarios()).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUsuario(Usuario usuarioNuevo) {
		Response resp = null;

		if (usuarioNuevo.validate()) {
			UsuarioManager um;
			try {
				um = UsuarioManager.getInstance();

				resp = Response.status(200).entity(um.createUsuario(usuarioNuevo)).build();
			} catch (Exception e) {
				e.printStackTrace();

				resp = Response.status(500).entity(new StatusMessage(500, "error")).build();
			}
		} else {
			resp = Response.status(400).entity(new StatusMessage(400, "Usuario incompleto")).build();
		}

		return resp;
	}

	@Path("/{nid}")
	@GET
	@Produces("application/json")
	public Response getUsuarios(@PathParam("nid") int nid) {

		UsuarioManager um;
		try {
			um = UsuarioManager.getInstance();

			return Response.status(200).entity(um.getUsuario(nid)).build();
		} catch (Exception e) {
			e.printStackTrace();

			return Response.status(500).entity(new StatusMessage(500, "error")).build();
		}
	}
	
	@Path("/{nid}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarUsuario(@PathParam("nid") int nid, Usuario unUsuario) {
		Response resp = null;

		unUsuario.setNid(nid);
		if (unUsuario.validate()) {
			UsuarioManager um;
			try {
				um = UsuarioManager.getInstance();

				resp = Response.status(200).entity(um.updateUsuario(unUsuario)).build();
			} catch (Exception e) {
				e.printStackTrace();

				resp = Response.status(500).entity(new StatusMessage(500, "error")).build();
			}
		} else {
			resp = Response.status(400).entity(new StatusMessage(400, "Usuario incompleto")).build();
		}

		return resp;
	}


}
