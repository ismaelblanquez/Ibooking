/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author Ismael
 */
public class Room {

    private Integer room_id;
    private Integer hotelId;
    private String room_type;
    private String description;
    private Double pricePerNight;
    private Boolean availability;

    public Room(Integer id, Integer hotelId, String type, String description, Double pricePerNight, boolean availability) {
        this.room_id = id;
        this.hotelId = hotelId;
        this.room_type = type;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.availability = availability;
    }

    public Integer getId() {
        return room_id;
    }

    public void setId(Integer id) {
        this.room_id = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getType() {
        return room_type;
    }

    public void setType(String type) {
        this.room_type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(Double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public Integer getRoom_id() {
        return room_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Room{" + "room_id=" + room_id + ", hotelId=" + hotelId + ", room_type=" + room_type + ", description=" + description + ", pricePerNight=" + pricePerNight + ", availability=" + availability + '}';
    }

    public static String 
        toArrayJSon(ArrayList<Room> rooms) {
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(rooms);
            
            return resp;
    }
}
