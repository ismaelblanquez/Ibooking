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
public class Location {

    private int id;
    private String city;
    private String country;

    public Location(String city, String country) {

        this.city = city;
        this.country = country;
    }

    public Location() {
        
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" + "id=" + id + ", city=" + city + ", country=" + country + '}';
    }

    public static String
            toArrayJSon(ArrayList<Location> locations) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(locations);

        return resp;
    }

    public static String
            toObjectJSon(User user) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(user);

        return resp;
    }
}
