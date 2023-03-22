package com.ismael.ibooking.Model.Pojo;

public class Location {
    private int id;
    private String city;
    private String country;

    public Location(String city, String country) {

        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
