/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ismael
 */
public class Hotel {

    private int hotel_id;
    private String name;
    private String description;
    private int rating;
    private int location;
    //private List<Room> rooms;

    public Hotel() {
    }

    public Hotel(String name, String description, int rating, int location) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        
        this.location = location;
       
    }

    public String getName() {
        return name;
    }

    public int getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

 

    public int getLocation() {
        return location;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

 

    public void setLocation(int location) {
        this.location = location;
    }

  

    @Override
    public String toString() {
        return "Hotel{" + "name=" + name + ", description=" + description + ", rating=" + rating + ", location=" + location + '}';
    }

    public static String
            toArrayJSon(ArrayList<Hotel> hotels) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(hotels);

        return resp;
    }

    public static String
            toObjectJSon(Hotel hotel) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(hotel);

        return resp;
    }
}
