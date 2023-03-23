/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.HotelDAO;
import DAO.RoomDAO;
import DAO.UserDAO;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Room;

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
     * Creates a new instance of Controllers
     */
    public Controller() {
    }

    /**
     * Retrieves representation of an instance of controller.Controllers
     * @return an instance of java.lang.String
     */
   @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {

        UserDAO userDao = new UserDAO();
        String trade = userDao.findAll(null).toString();

        return trade;

    }

    @GET
    @Path("/hotels")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHotels() {

        HotelDAO hotelDao = new HotelDAO();
        String trade = hotelDao.findAll(null).toString();

        return trade;

    }
   @GET
    @Path("/rooms")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String buscarCine () {
        RoomDAO roomDao = new RoomDAO();
        Room room = new Room();
        
        ArrayList<Room> rooms = roomDao.findAll(room);
        return Room.toArrayJSon(rooms);
    }

    /**
     * PUT method for updating or creating an instance of Controllers
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
