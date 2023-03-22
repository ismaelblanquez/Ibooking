/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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
 * @author A7-PC00
 */
@Path("helloworld")
public class Helloworld {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of Helloworld
     */
    public Helloworld() {
    }

    /**
     * Retrieves representation of an instance of DAO.Helloworld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ArrayList<Pelicula> peliculas = peliculaDao.findAll(null);
        String resp = Pelicula.toArrayJSon(peliculas);
        //JsonParser parser = new JsonParser();
       //JsonElement tradeElement = parser.parse(resp);
       //JsonArray trade = tradeElement.getAsJsonArray();
       return resp;
    }

    /**
     * PUT method for updating or creating an instance of Helloworld
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
