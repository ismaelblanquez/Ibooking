/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author S1-PC52
 */
@Path("api")
public class Controller {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    /**
     * Retrieves representation of an instance of controller.Controller
     * @return an instance of java.lang.String
     */
    @GET
    @Path("hoteles")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "patata";
    }

    /**
     * PUT method for updating or creating an instance of Controller
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
