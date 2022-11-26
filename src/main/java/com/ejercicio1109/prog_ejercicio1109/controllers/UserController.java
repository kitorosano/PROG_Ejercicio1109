package com.ejercicio1109.prog_ejercicio1109.controllers;

import com.ejercicio1109.prog_ejercicio1109.dtos.UserDTO;
import com.ejercicio1109.prog_ejercicio1109.services.UserService;
import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
public class UserController {
  
  UserService userService = new UserService();
  
  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAll() {
    try {
      List<UserDTO> users = userService.findAll();
      if (users != null) {
        return Response.ok(new Gson().toJson(users)).build();
      } else {
        return Response.status(Response.Status.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
    }
  }
  
  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response findById(@PathParam("id") String id) {
    try {
      UserDTO user = userService.findById(id).orElse(null);
      
      if (user != null) {
        return Response.ok(new Gson().toJson(user)).build();
      } else {
        return Response.status(Response.Status.NOT_FOUND).build();
      }
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
    }
  }
  
  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(UserDTO user) {
    try {
      userService.create(user);
      return Response.status(Response.Status.CREATED).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
    }
  }
  
  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateById(@PathParam("id") String id, UserDTO user) {
    try {
      userService.updateById(id, user);
      return Response.status(Response.Status.NO_CONTENT).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
    }
  }
  
  @DELETE
  @Path("/{id}")
  public Response deleteById(@PathParam("id") String id) {
    try {
      userService.deleteById(id);
      return Response.status(Response.Status.NO_CONTENT).build();
    } catch (Exception e) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), e.getMessage()).build();
    }
  }
}