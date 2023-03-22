/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Pelicula;

/**
 * REST Web Service
 *
 * @author A10
 */
@Path("peliculasws")
public class PeliculaswsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PeliculaswsResource
     */
    public PeliculaswsResource() {
    }

    /**
     * Retrieves representation of an instance of DAO.PeliculaswsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDao.
                findAll(null);
        return Pelicula.toArrayJSon(peliculas);
    }

    /**
     * PUT method for updating or creating an instance of PeliculaswsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
