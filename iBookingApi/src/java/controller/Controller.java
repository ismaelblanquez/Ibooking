/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CommentDAO;
import DAO.HotelDAO;
import DAO.LocationDAO;
import DAO.ReservationDAO;
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
import model.Comment;
import model.Hotel;
import model.Location;
import model.Reservation;
import model.Room;
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
     * Creates a new instance of Controllers
     */
    public Controller() {
    }

    /**
     * Retrieves representation of an instance of controller.Controllers
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUsers() {
        UserDAO userDAO = new UserDAO();
        ArrayList<User> users = userDAO.findAll(null);
        return User.toArrayJSon(users);
    }
    
     @GET
    @Path("/locations")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocations() {
        LocationDAO locationDAO = new LocationDAO();
        ArrayList<Location> locations = locationDAO.findAll(null);
        return Location.toArrayJSon(locations);
    }

    @GET
    @Path("/hotels")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHotels() {
        HotelDAO hotelDAO = new HotelDAO();
        ArrayList<Hotel> hotels = hotelDAO.findAll(null);
        return Hotel.toArrayJSon(hotels);
    }

    @GET
    @Path("/rooms")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRooms() {
        RoomDAO roomDAO = new RoomDAO();
        ArrayList<Room> rooms = roomDAO.findAll(null);
        return Room.toArrayJSon(rooms);
    }
    
    @GET
    @Path("/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public String getReservations() {
        ReservationDAO reservationDAO = new ReservationDAO();
        ArrayList<Reservation> reservations = reservationDAO.findAll(null);
        return Reservation.toArrayJSon(reservations);
    }

     @GET
    @Path("/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public String getComments() {
        CommentDAO commentDAO = new CommentDAO();
        ArrayList<Comment> comments = commentDAO.findAll(null);
        return Comment.toArrayJSon(comments);
    }
    /**
     * PUT method for updating or creating an instance of Controllers
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
