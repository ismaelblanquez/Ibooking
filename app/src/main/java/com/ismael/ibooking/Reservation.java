package com.ismael.ibooking;

package com.example.booking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reservation {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("user")
    @Expose
    private User user;

    @SerializedName("room")
    @Expose
    private Room room;

    @SerializedName("checkin")
    @Expose
    private String checkin;

    @SerializedName("checkout")
    @Expose
    private String checkout;

    @SerializedName("guests")
    @Expose
    private Integer guests;

    @SerializedName("total_price")
    @Expose
    private Double totalPrice;

    @SerializedName("status")
    @Expose
    private String status;

    public Reservation(User user, Room room, String checkin, String checkout, Integer guests, Double totalPrice, String status) {
        this.user = user;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.guests = guests;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Integer getId() {
        return id;
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

    public Integer getGuests() {
        return guests;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public String getStatus() {
        return status;
    }
}
