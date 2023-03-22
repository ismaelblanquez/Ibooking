package com.ismael.ibooking.Model.Pojo;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reservation {

    @SerializedName("reservation_id")
    @Expose
    private Integer reservation_id;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("room")
    @Expose
    private Room room;

    @SerializedName("hotel")
    @Expose
    private Hotel hotel;

    @SerializedName("checkin")
    @Expose
    private String checkin;

    @SerializedName("checkout")
    @Expose
    private String checkout;



    public Reservation(User user, Room room, String checkin, String checkout) {
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
    }



    public Integer getReservation_id() {
        return reservation_id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

}
