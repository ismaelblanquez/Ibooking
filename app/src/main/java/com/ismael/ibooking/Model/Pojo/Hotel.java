package com.ismael.ibooking.Model.Pojo;

import android.location.Location;

import java.util.List;

public class Hotel {
    private String name;
    private String description;
    private int rating;
    private double pricePerNight;
    private Location location;
    private List<Room> rooms;

    public Hotel(String name, String description, int rating, double pricePerNight, Location location, List<Room> rooms) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.pricePerNight = pricePerNight;
        this.location = location;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public Location getLocation() {
        return location;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
