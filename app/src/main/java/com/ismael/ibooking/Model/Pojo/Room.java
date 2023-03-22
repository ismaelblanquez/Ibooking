package com.ismael.ibooking.Model.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Room {
    @SerializedName("room_id ")
    @Expose
    private Integer room_id ;
    @SerializedName("hotelId")
    @Expose
    private Integer hotelId;
    @SerializedName("room_type ")
    @Expose
    private String room_type ;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("pricePerNight")
    @Expose
    private Double pricePerNight;
    @SerializedName("availability ")
    @Expose
    private Boolean availability ;

    public Room(Integer id, Integer hotelId, String type, String description, Double pricePerNight, boolean availability) {
        this.room_id  = id;
        this.hotelId = hotelId;
        this.room_type  = type;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.availability  = availability ;
    }

    public Integer getId() {
        return room_id ;
    }

    public void setId(Integer id) {
        this.room_id  = id;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getType() {
        return room_type ;
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
}
