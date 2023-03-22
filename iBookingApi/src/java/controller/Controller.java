/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.HotelDAO;
import DAO.UserDAO;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Hotel;
import model.User;

/**
 * REST Web Service
 *
 * @author Ismael
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
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("hoteles")
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray getJson() {

        UserDAO userDao = new UserDAO();
        ArrayList<User> users = userDao.findAll(null);
        String resp = User.toArrayJSon(users);
        JsonParser parser = new JsonParser();
        JsonElement tradeElement = parser.parse(resp);
        JsonArray trade = tradeElement.getAsJsonArray();
        System.out.println("He llegado a hoteles y te mando:");
        System.out.println(trade);
        return trade;

    }

    /**
     * PUT method for updating or creating an instance of Controller
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
